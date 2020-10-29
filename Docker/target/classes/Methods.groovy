class Person {
    String firstName, lastName
}

def printInfo(x1, x2) {
    print "$x1 $x2"
}

def printInfo(user) {
    println "$user.firstName $user.lastName"
}

def tempPerson = new Person(firstName: 'Adam', lastName: 'Kechinsky')

printInfo('hello', 'world')
printInfo(tempPerson)

def printString(String s) {
    println(s)
}

String a = 2
printString(a)

int getInt(i) {
    i + 2
}

int b = getInt(3)
println b