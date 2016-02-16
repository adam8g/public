package com.wtc.enhanced_seq

class EnhancedSeq[A](val thisSeq: scala.collection.Seq[A])
{
  import com.wtc.enhanced_seq.EnhancedSeq._
  
  def applyRightOption(n: Int): Option[A] =
  {
    n match
    {
      case _ if n > 0 && n <= thisSeq.length => thisSeq takeRight(n) headOption
      case _ => None
    }
  }
  
  def areInclusiveMultisets(thatSeq: scala.collection.Seq[A]): Boolean = 
  { 
    val (smallSeq, largeSeq) = thisSeq match
    {
      case _ if thisSeq.length < thatSeq.length => (thisSeq, thatSeq)
      case _ => (thatSeq, thisSeq)
    }
    
    smallSeq.intersect(largeSeq).multiset == smallSeq.multiset
  }
   
  def multiset(): scala.collection.Map[A,Int] = 
  {
    thisSeq.foldLeft(scala.collection.mutable.Map[A,Int]() withDefaultValue 0) { (map, element) => map + (element -> (1 + map(element))) }
  }   
}

object EnhancedSeq
{
  implicit def seqToEnhancedSeq[A](thatSeq: scala.collection.Seq[A]): EnhancedSeq[A]  = new EnhancedSeq(thatSeq)
}