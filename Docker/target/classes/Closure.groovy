//Closure - это замыкание и представляет собой некую анонимную функцию со свойствами объекта.
//Синтаксис замыкания : { [closureArguments->] statements }

def closureFunction = {a, b ->
    println a
    println b
}

closureFunction(1, 2)

//В замыканиях по умолчанию присутствует переменная it
// и ссылается на первый параметр в замыкании:
def closureA = { it }
println closureA(1)

def nullAble() {}
println nullAble()

// Вызов замыкания
def c = { it, arg -> println "${it} ${arg}" }
c.call("A", "B") // первый тип вызова
c("C", "D") // второй тип вызова


//Определение замыкания в классе и его вызов:
class ClassWithClosure {
    private int member = 20

    private String method() {
        "hello"
    }

    def publicMethodWithClosure(String name_) {
        def localVar = member + 5
        def localVar2 = "Parameter: ${name_}"

        // Собственно, само замыкание
        return {
            println "${member} ${name_} ${localVar} ${localVar2} ${method()}"
        }
    }
}

ClassWithClosure sample = new ClassWithClosure();
def closureVar = sample.publicMethodWithClosure("Xavier")
closureVar()


//Специальный класс Expando для создания динамических объектов и методов (как замыкания) которые можно вызывать:
def player = new Expando()
player.name = "Alec"
player.greeting = { "Hello, my name is $name" }

println player.greeting()
player.name = "Max"
println player.greeting()