import java.awt.*
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import java.awt.geom.*
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.SwingWorker

/**
 * This class adds functionality to process
 * [SVG Path commands](https://de.wikipedia.org/wiki/Scalable_Vector_Graphics#Pfad)
 * (This is the german Wikipedia page bc the english one doesn't have this table)
 */
class SvgPath : Path2D.Double() {

    private val lastMovePoint = Point2D.Double(0.0, 0.0)

    /**
     * The normal [moveTo] ("M") command, but it saves the position
     * to be later used in [closeLine] ("z") commands
     */
    fun moveToAndSave(x: kotlin.Double, y: kotlin.Double) {
        moveTo(x, y)
        lastMovePoint.x = x
        lastMovePoint.y = y
    }

    /**
     * The **relative** [moveTo] ("m") command, but it saves the position
     * to be later used in [closeLine] ("z") commands
     */
    fun relativeMoveTo(x: kotlin.Double, y: kotlin.Double) {
        val cX = currentPoint.x
        val cY = currentPoint.y
        moveToAndSave(cX + x, cY + y)
    }

    /**
     * The "Z" command draws a line to the last saved [moveToAndSave] ("M") or [relativeMoveTo] ("m")
     * position
     */
    fun closeLine() = lineTo(lastMovePoint.x, lastMovePoint.y)

    /**
     * The "l" command draws a line to the given **relative** coordinates
     */
    fun relativeLineTo(x: kotlin.Double, y: kotlin.Double) {
        val cX = currentPoint.x
        val cY = currentPoint.y
        lineTo(cX + x, cY + y)
    }

    /**
     * The "H" command draws a horizontal line
     */
    fun hline(x: kotlin.Double) = lineTo(x, currentPoint.y)

    /**
     * The "h" command draws a **relative** horizontal line
     */
    fun relativeHline(x: kotlin.Double) = lineTo(currentPoint.x + x, currentPoint.y)

    /**
     * The "C" command draws a cubic bézier curve
     */
    fun curveTo(p1: Point2D.Double, x2: kotlin.Double, y2: kotlin.Double, x3: kotlin.Double, y3: kotlin.Double) =
        curveTo(p1.x, p1.y, x2, y2, x3, y3)

    /**
     * The "c" command draws a **relative** cubic bézier curve
     */
    fun relativeCurveTo(x1: kotlin.Double, y1: kotlin.Double, x2: kotlin.Double, y2: kotlin.Double, x3: kotlin.Double, y3: kotlin.Double) {
        val x = currentPoint.x
        val y = currentPoint.y
        curveTo(x + x1, y + y1, x + x2, y + y2, x + x3, y + y3)
    }

    /**
     * The "c" command draws a **relative** cubic bézier curve
     */
    fun relativeCurveTo(p1: Point2D.Double, x2: kotlin.Double, y2: kotlin.Double, x3: kotlin.Double, y3: kotlin.Double) =
        relativeCurveTo(p1.x, p1.y, x2, y2, x3, y3)

    /**
     * The "S" command draws a "smooth" cubic bézier curve by using the second point of the last curve as its first one
     */
    fun smoothCurveTo(lastP2: Point2D.Double, x2: kotlin.Double, y2: kotlin.Double, x3: kotlin.Double, y3: kotlin.Double) =
        curveTo(lastP2.mirrorAround(currentPoint), x2, y2, x3, y3)

    /**
     * The "S" command draws a "smooth" cubic bézier curve by using the second point of the last curve as its first one
     */
    fun smoothCurveTo(lastX2: kotlin.Double, lastY2: kotlin.Double, x2: kotlin.Double, y2: kotlin.Double, x3: kotlin.Double, y3: kotlin.Double) =
        smoothCurveTo(Point2D.Double(lastX2, lastY2), x2, y2, x3, y3)

    /**
     * The "s" command draws a **relative** "smooth" cubic bézier curve by using the second point of the last curve as its first one
     */
    fun relativeSmoothCurveTo(lastP2: Point2D.Double, x2: kotlin.Double, y2: kotlin.Double, x3: kotlin.Double, y3: kotlin.Double) =
        relativeCurveTo(-lastP2.x, -lastP2.y, x2, y2, x3, y3)

    /**
     * The "s" command draws a **relative** "smooth" cubic bézier curve by using the second point of the last curve as its first one
     */
    fun relativeSmoothCurveTo(lastX2: kotlin.Double, lastY2: kotlin.Double, x2: kotlin.Double, y2: kotlin.Double, x3: kotlin.Double, y3: kotlin.Double) =
        relativeSmoothCurveTo(Point2D.Double(lastX2, lastY2), x2, y2, x3, y3)

    /**
     * Helper method to mirror a point around a center
     */
    private fun Point2D.mirrorAround(center: Point2D): Point2D.Double {
        val dX = center.x - x
        val dY = center.y - y

        return Point2D.Double(center.x + dX, center.y + dY)
    }
}

/**
 * This shape is a deconstruction of the
 * [DVD Logo SVG](https://commons.wikimedia.org/wiki/File:DVD_logo.svg),
 * which is Public Domain
 */
class DvdShape : RectangularShape() {

    private val bounds = Rectangle2D.Double()
    private val path = SvgPath()

    override fun getBounds2D() = bounds
    override fun contains(x: Double, y: Double) = bounds.contains(x, y)
    override fun contains(x: Double, y: Double, w: Double, h: Double) = bounds.contains(x, y, w, h)
    override fun intersects(x: Double, y: Double, w: Double, h: Double) = bounds.intersects(x, y, w, h)
    override fun getX() = bounds.x
    override fun getY() = bounds.y
    override fun getWidth() = bounds.width
    override fun getHeight() = bounds.height
    override fun isEmpty() = bounds.isEmpty
    override fun setFrame(x: Double, y: Double, w: Double, h: Double) = bounds.setFrame(x, y, w, h)
    override fun getPathIterator(at: AffineTransform?): PathIterator = path.getPathIterator(at)

    init {
        //Draw DVD Letters
        path.moveToAndSave(118.895, 20.346)
        path.relativeCurveTo(0.0, 0.0, -13.743,16.922,-13.04,18.001)
        path.relativeCurveTo(0.975, -1.079, -4.934, -18.186, -4.934, -18.186)
        path.relativeSmoothCurveTo(-4.934, -18.186, -1.233, -3.597, -5.102, -15.387)
        path.hline(81.81)
        path.hline(47.812)
        path.hline(22.175)
        path.relativeLineTo(-2.56, 11.068)
        path.relativeHline(19.299)
        path.relativeHline(4.579)
        path.relativeCurveTo(12.415, 0.0,  19.995, 5.132, 17.878, 14.225)
        path.relativeCurveTo(-2.287, 9.901, -13.123, 14.128, -24.665, 14.128)
        path.hline(32.39)
        path.relativeLineTo(5.552, -24.208)
        path.hline(18.647)
        path.relativeLineTo(-8.192, 35.368)
        path.relativeHline(27.398)
        path.relativeCurveTo(20.612, 0.0, 40.166, -11.067, 43.692, -25.288)
        path.relativeCurveTo(0.617, -2.614, 0.53, -9.185, -1.054, -13.053)
        path.relativeCurveTo(0.0, -0.093, -0.091, -0.271, -0.178, -0.537)
        path.relativeCurveTo(-0.087, -0.093, -0.178, -0.722, 0.178, -0.814)
        path.relativeCurveTo(0.172, -0.092, 0.525, 0.271, 0.525, 0.358)
        path.relativeCurveTo(0.0, 0.0, 0.179, 0.456, 0.351, 0.813)
        path.relativeLineTo(17.44, 50.315)
        path.relativeLineTo(44.404, -51.216)
        path.relativeLineTo(18.761, -0.092)
        path.relativeHline(4.579)
        path.relativeCurveTo(12.424, 0.0, 20.09, 5.132, 17.969, 14.225)
        path.relativeCurveTo(-2.29, 9.901, -13.205, 14.128, -24.75, 14.128)
        path.relativeHline(-4.405)
        path.lineTo(161.0, 19.987)
        path.relativeHline(-19.287)
        path.relativeLineTo(-8.198, 35.368)
        path.relativeHline(27.398)
        path.relativeCurveTo(20.611, 0.0, 40.343, -11.067, 43.604, -25.288)
        path.relativeCurveTo(3.347, -14.225, -11.101, -25.293, -31.89, -25.293)
        path.relativeHline(-18.143)
        path.relativeHline(-22.727)
        path.curveTo(120.923, 17.823, 118.895, 20.346, 118.895, 20.346)
        path.lineTo(118.895, 20.346)
        path.closeLine()

        //Draw outer Disc
        path.moveToAndSave(99.424, 67.329)
        path.curveTo(47.281, 67.329,5.0, 73.449, 5.0, 81.012)
        path.relativeCurveTo(0.0, 7.558, 42.281, 13.678, 94.424, 13.678)
        path.relativeCurveTo(52.239, 0.0, 94.524, -6.12, 94.524, -13.678)
        path.curveTo(193.949, 73.449, 151.664, 67.329, 99.424, 67.329)
        path.closeLine()

        //Draw inner disc
        path.moveToAndSave(96.078, 85.873)
        path.relativeCurveTo(-11.98, 0.0, -21.58, -2.072, -21.58, -4.595)
        path.relativeCurveTo(0.0, -2.523, 9.599, -4.59, 21.58, -4.59)
        path.relativeCurveTo(11.888, 0.0, 21.498, 2.066, 21.498, 4.59)
        path.curveTo(117.576, 83.801, 107.966, 85.873, 96.078, 85.873)
        path.closeLine()

        bounds.frame = path.bounds
    }
}

/**
 * This panel handles the rendering and coloring of the logo
 */
class DvdPanel : JPanel() {

    companion object {
        private val colors = listOf(
            Color(0, 255, 255),
            Color(255, 127, 0),
            Color(0, 0, 255),
            Color(255, 255, 0),
            Color(255, 0, 0),
            Color(255, 0, 255),
            Color(127, 0, 255)
        )
    }

    val dvd = DvdShape()
    private var colorIndex = 0
    var pos = Point2D.Double(0.0, 0.0)

    override fun paint(g: Graphics?) {
        super.paint(g)

        val g2d = g as Graphics2D

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_SPEED)
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_SPEED)
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED)
        g2d.color = colors[colorIndex]
        g2d.translate(pos.x, pos.y)
        g2d.fill(dvd)
    }

    fun nextColor() {
        colorIndex++
        if (colorIndex >= colors.size) colorIndex = 0
    }
}

/**
 * The main frame containing the [DvdPanel]
 */
class DvdFrame : JFrame() {

    private class WindowClosingListener(val listener : () -> Unit) : WindowAdapter() {
        override fun windowClosing(p0: WindowEvent?) = listener()
    }

    private val panel = DvdPanel()
    private val worker = DVDWorker(panel)

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        bounds = Rectangle(100, 100, 750, 500)
        title = "DVD Logo"
        contentPane = panel

        addWindowListener(WindowClosingListener { worker.finish() } )
        worker.start()
    }
}

/**
 * This worker thread handles the game logic
 */
class DVDWorker(private val panel: DvdPanel) : Thread("DVD Worker") {

    private val frameWidth: Int
        get() = panel.width
    private val frameHeight: Int
        get() = panel.height

    private var x: Double
        get() = panel.pos.x
        set(value) {
            panel.pos.x = value
        }

    private var y: Double
        get() = panel.pos.y
        set(value) {
            panel.pos.y = value
        }

    private val width: Double
        get() = panel.dvd.width

    private val height: Double
        get() = panel.dvd.height

    private var xDir = 1
    private var yDir = 1
    private var running = false

    override fun run() {
        running = true
        while (running) {
            x += xDir * 5
            y += yDir * 5

            if (x + width > frameWidth) {
                xDir = -1
                x = frameWidth - width
                panel.nextColor()
            } else if (x < 0) {
                xDir = 1
                x = 0.0
                panel.nextColor()
            }
            if (y + height > frameHeight) {
                yDir = -1
                y = frameHeight - height
                panel.nextColor()
            } else if (y < 0) {
                yDir = 1
                y = 0.0
                panel.nextColor()
            }

            panel.repaint()
            try {
                sleep(20)
            } catch (_: InterruptedException) {
                running = false
            }
        }
    }

    fun finish() {
        running = false
    }
}

fun main() {
    EventQueue.invokeLater {
        val frame = DvdFrame()
        frame.setLocationRelativeTo(null)
        frame.isVisible = true
    }
}