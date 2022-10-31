using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraController : MonoBehaviour
{
    public static CameraController instance;
    public Transform target;
    public Vector3 offset;

    [Range(0, 3)] public float smoothSpeed; public float orthographicSize;

    private void Awake()
    {

        instance = this;

    }

    private void Update()
    {

        FollowTarget();
        CameraConfiguration();

    }

    void CameraConfiguration()
    {

        this.GetComponent<Camera>().orthographicSize = orthographicSize;

    }

    void FollowTarget()
    {

        Vector3 desiredPosition = target.position + offset;
        Vector3 smoothedPosition = Vector3.Lerp(transform.position, desiredPosition, smoothSpeed * Time.deltaTime);
        this.transform.position = smoothedPosition;

    }

}