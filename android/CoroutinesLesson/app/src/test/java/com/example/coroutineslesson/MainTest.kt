package com.example.coroutineslesson

import org.junit.Assert
import org.junit.Test


class MainTest {

    @Test
    fun testSumReturnsCorrectValue() {
        Assert.assertEquals(5, sum(2, 3))
        Assert.assertEquals(10, sum(1, 9))
        Assert.assertEquals(1000, sum(500, 500))
    }
}