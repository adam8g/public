package com.wtc.enhanced_seq

import org.scalatest.Assertions
import org.junit.Test

import com.wtc.enhanced_seq.EnhancedSeq._

class TestEnhancedSeq extends Assertions {
  
  @Test
  def testApplyRightOption()
  {
    val enhancedList = List(1, 2, 3, 4, 5, 6, 7)
    assert(enhancedList.applyRightOption(5) === Some(3))    
    assert(enhancedList.applyRightOption(8) === None)
    assert(enhancedList.applyRightOption(0) === None)
    assert(enhancedList.applyRightOption(-1) === None)
  }
  
  @Test
  def testAreInclusiveMultisets()
  {
    var enhancedList1 = List(2, 2, 1, 4, 4, 3, 3)
    var enhancedList2 = List(2, 1, 1, 4, 4, 3, 4)
    
    assert(enhancedList1.areInclusiveMultisets(enhancedList2) === false)
    assert(enhancedList2.areInclusiveMultisets(enhancedList1) === false)
    
    enhancedList1 = List(2, 2, 1, 4, 4, 3, 3)
    enhancedList2 = List(5, 2, 5, 2, 5, 1, 5, 4, 5, 4, 5, 3, 5, 3, 5)
    
    assert(enhancedList1.areInclusiveMultisets(enhancedList2) === true)
    assert(enhancedList2.areInclusiveMultisets(enhancedList1) === true)
    
    enhancedList1 = List(2, 2, 1, 4, 4, 3, 3)
    enhancedList2 = List(2, 2, 1, 4, 4, 3, 3)
    
    assert(enhancedList1.areInclusiveMultisets(enhancedList2) === true)
    assert(enhancedList2.areInclusiveMultisets(enhancedList1) === true)
    
    enhancedList1 = Nil
    enhancedList2 = List(2, 2, 1, 4, 4, 3, 3)
    
    assert(enhancedList1.areInclusiveMultisets(enhancedList2) === true)
    assert(enhancedList2.areInclusiveMultisets(enhancedList1) === true)
    
    enhancedList1 = Nil
    enhancedList2 = Nil
    
    assert(enhancedList1.areInclusiveMultisets(enhancedList2) === true)
    assert(enhancedList2.areInclusiveMultisets(enhancedList1) === true)
  }
}