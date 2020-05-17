package main.groovy.ifmo

import groovy.time.TimeCategory
import java.time.*
import java.util.*
import groovy.sql.Sql

//Ypra 1
println "Welcome, Groovy"

try{
    def firstClassParameters = new FirstClass(id: 11, isBlocked: false)
} catch (Exception e){
    println "Cannot create FirstClass"
}

def firstClassConstructor = new FirstClass(11, false)

def firstClassBindings = new FirstClass()
println firstClassBindings.binding.id

println "Integer instanceof String: ${5 instanceof String}"
println "String instanceof Integer: ${"" instanceof Integer}"

//Ypra 2
int methodReturnsInt(Integer a) { a }
Integer methodReturnsInteger(Integer a) { a }

try {
    println methodReturnsInt(null)
} catch ( Exception e){
    println "Method which returns int has failed"
}

try {
    println methodReturnsInteger(null)
} catch ( Exception e){
    println "Method which returns Integer has failed"
}

def bigDecimal1 = new BigDecimal(5)
def bigDecimal2 = new BigDecimal(5)

println "System.identityHashCode(bigDecimal1) = ${System.identityHashCode(bigDecimal1)}"
println "System.identityHashCode(bigDecimal2) = ${System.identityHashCode(bigDecimal2)}"
println "Are objects at the same memory address? "
println "${System.identityHashCode(bigDecimal1) == System.identityHashCode(bigDecimal2)}"

println "bigDecimal1.equals(bigDecimal2) = ${bigDecimal1.equals(bigDecimal2)}"
println "bigDecimal1 == bigDecimal2 = ${bigDecimal1 == bigDecimal2}"
println "bigDecimal1.compareTo(bigDecimal2) = ${bigDecimal1.compareTo(bigDecimal2)}"
println "bigDecimal1.add(bigDecimal2) = ${bigDecimal1.add(bigDecimal2)}"
println "bigDecimal1 + bigDecimal2 = ${bigDecimal1 + bigDecimal2}"
println "bigDecimal1.divide(bigDecimal2) = ${bigDecimal1.divide(bigDecimal2)}"
println "bigDecimal1 / bigDecimal2 = ${bigDecimal1 / bigDecimal2}"
println "bigDecimal1.multiply(bigDecimal2) = ${bigDecimal1.multiply(bigDecimal2)}"
println "bigDecimal1 * bigDecimal2 = ${bigDecimal1 * bigDecimal2}"

JavaClass javaClass = new JavaClass()
javaClass.bigDecimal()

def variable = "first"
println "variable type: ${variable.getClass()}"
variable = 10
println "variable type: ${variable.getClass()}"
variable = 'd'
println "variable type: ${variable.getClass()}"

Date date1 = new GregorianCalendar(2019, Calendar.NOVEMBER, 11).getTime();
Date date2 = new GregorianCalendar(2019, Calendar.JANUARY, 21).getTime();

println date1
println date2
println "date1 - date2 ${date1.getTime() - date2.getTime()}"

use(TimeCategory) {
    def dateMonth = date1 - 1.month
    println dateMonth
    def dateMonthDay = dateMonth + 1.month + 1.day
    println dateMonthDay
}

// Ypra3
def division = { a, b -> a / b }
println "21/7 = ${division(21, 7)}"
println "7/21 = ${division(7, 21)}"

def substraction = { d, c -> d - c }
println "21-1 = ${substraction(21, 1)}"

def combined = { a, b, c -> substraction(division(a, b), c) }
println "21 / 1 - 1 = ${combined(21, 1, 1)}"

// Ypra4
sql = Sql.newInstance("jdbc:oracle:thin:@localhost:1521:orcl", "hr11", "hr11",
        "oracle.jdbc.pool.OracleDataSource")

sql.eachRow('SELECT * FROM employees'){
    row -> println row
}