package com.wtc.triangle

class Triangle private (val a: Double, val b: Double, val c: Double)
{
  import com.wtc.triangle.TriangleType._
  
  def getType(): Option[TriangleType] =
  {
    if (isEquilateral()) Some(TriangleType.Equilateral)
    else if (isOsceles()) Some(TriangleType.Osceles)
    else Some(TriangleType.Scalene)
  }
  
  def isTriangle(): Boolean =
  {
    a > 0 && b > 0 && c > 0 && a+b > c && a+c > b && b+c > a
  }
  
  def isEquilateral(): Boolean =
  {
    a == b && b == c
  }  
  
  def isOsceles(): Boolean =
  {
    a == b || b ==c || c == a
  } 
}

object Triangle
{
  def apply(a: Double, b: Double, c: Double): Option[Triangle] = 
  {
    val triangle = new Triangle(a, b, c)
    
    a match
    {
      case _ if triangle.isTriangle() => Some(triangle)
      case _ => None
    }
  }
}