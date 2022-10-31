using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlataformBehaviour : MonoBehaviour
{
    public float speed, distance, direction;
    public Vector2 initialPosition;
    public Rigidbody2D rb;

    void Start()
    {
        initialPosition = this.transform.position;
    }

    void Update()
    {
        if (this.transform.position.y >= initialPosition.y + distance)
            direction = -1;
        else if (this.transform.position.y <= initialPosition.y - distance)
            direction = 1;
        rb.velocity = new Vector2(rb.velocity.x, direction * speed * Time.deltaTime);
    }
}
