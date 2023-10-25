import java.awt.EventQueue
import java.awt.Graphics
import java.awt.Rectangle
import java.awt.geom.*
import javax.swing.JFrame
import javax.swing.JPanel


class DvdShape : RectangularShape() {

    private val bounds = Rectangle2D.Double()
    private val path = Path2D.Double()

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
        path.moveTo(118.895, 20.346)
        path.curveTo(0.0, 0.0, -13.743,16.922,-13.04,18.001)
        path.curveTo(0.975, -1.079, -4.934, -18.186, -4.934, -18.186)
        path.smoothCurveTo(-4.934, -18.186, -1.233, -3.597, -5.102, -15.387)
    }

    private fun Path2D.Double.curveTo(p1: Point2D.Double, x2: Double, y2: Double, x3: Double, y3: Double) =
        curveTo(p1.x, p1.y, x2, y2, x3, y3)

    private fun Path2D.Double.smoothCurveTo(lastP2: Point2D.Double, x2: Double, y2: Double, x3: Double, y3: Double) =
        curveTo(lastP2.mirrorAround(currentPoint), x2, y2, x3, y3)

    private fun Path2D.Double.smoothCurveTo(lastX2: Double, lastY2: Double, x2: Double, y2: Double, x3: Double, y3: Double) =
        smoothCurveTo(Point2D.Double(lastX2, lastY2), x2, y2, x3, y3)

    private fun Point2D.mirrorAround(center: Point2D): Point2D.Double {
        val dX = center.x - x
        val dY = center.y - y

        return Point2D.Double(center.x + dX, center.y + dY)
    }
}

class DvdPanel : JPanel() {
    override fun paint(g: Graphics?) {
        super.paint(g)


    }
}

class DvdFrame : JFrame() {

    private val canvas = DvdPanel()

    init {
        defaultCloseOperation = EXIT_ON_CLOSE
        bounds = Rectangle(100, 100, 750, 500)
        title = "DVD Logo"

        contentPane = canvas
    }
}

fun main() {
    EventQueue.invokeLater {
        val frame = DvdFrame()
        frame.setLocationRelativeTo(null)
        frame.isVisible = true
    }
}