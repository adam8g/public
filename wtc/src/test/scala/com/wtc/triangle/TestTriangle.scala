package com.wtc.triangle

import org.scalatest.Assertions
import org.junit.Test

class TestTriangle extends Assertions {

  @Test
  def testTriangle()
  {
    var triangle = Triangle(5, 7, 10)
    assert(triangle.get.getType() === Some(TriangleType.Scalene))
    
    triangle = Triangle(5D, 5D, 3D)
    assert(triangle.get.getType() === Some(TriangleType.Osceles))
    
    triangle = Triangle(5.5, 5.5, 5.5)
    assert(triangle.get.getType() === Some(TriangleType.Equilateral))
    
    triangle = Triangle(1, 1, 5.5)
    assert(triangle === None)
    
    triangle = Triangle(-1, 1, 5.5)
    assert(triangle === None)
  }
}
