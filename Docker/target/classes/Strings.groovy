println  "hello"
println 'ab' == 'a' + 'b'

println '''a triple-single-quoted string'''

def aMultilineString = '''line one\
line two
line three'''

println aMultilineString

def name = 'Guillaume' // a plain string
def greeting = "Hello ${name}"

println greeting

def sum = "The sum of 2 and 3 equals ${2 + 3}"
println sum.toString() == 'The sum of 2 and 3 equals 5'

def person = [name: 'Guillaume', age: 36]
println "$person.name is $person.age years old"


//Closures
def sParameterLessClosure = "1 + 2 == ${-> 3}"
//The closure is a parameterless closure which doesn’t take arguments.
println sParameterLessClosure

def sOneParamClosure = "1 + 2 == ${ w -> w << 3}"
// Here, the closure takes a single java.io.StringWriter
// argument, to which you can append content with the << leftShift operator.
// In either case, both placeholders are embedded closures.
println sOneParamClosure

def number = 1
def eagerGString = "value == ${number}"
def lazyGString = "value == ${ -> number }"

println number
println eagerGString
println lazyGString


String takeString(String message) {
    assert message instanceof String
    return message
}

def message = "The message is ${'hello'}"
println message instanceof GString

def result = takeString(message)
println result instanceof String

def key = "a"
def m = ["${key}": "letter ${key}"]
println m

def c2 = 'B' as char
println c2 instanceof Character

String a = 9
println "${a + 3}"

def ar = 's'
println a instanceof java.lang.Byte

def map = [1: 'java']

def key1 = 'name'
def person1 = [key: 'Guillaume']
println person1

person1 = [(key1): 'Guillaume']

println person1
println person1.getClass()

//------------------------------------------------------------

randomName = /This is my new string./
println randomName
println randomName.class //java.lang.String

def b = "abcde" // также строка представляет собой и список символов
println b[2] // напечатает c
println b[1..3] // напечатает bcd

println "reverse me".reverse()
println "This is the end, my only friend!".tokenize(' ').reverse().join(' ')
