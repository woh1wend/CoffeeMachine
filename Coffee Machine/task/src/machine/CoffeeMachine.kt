package machine

class CoffeeMachine constructor(private var _water: Int = 400,
                                private var _milk: Int = 540,
                                private var _beans: Int = 120,
                                private var _cups: Int = 9,
                                private var _money: Int = 550) {


    fun action(){
        var action: String
        do {
            println("Write action (buy, fill, take, remaining, exit):")
            action = readln()
            when (action) {
                "buy" -> buy()
                "fill" -> fill()
                "take" -> take()
                "remaining" -> remaining()
            }
        }while (action != "exit")
    }

    private fun printFinal() {
        println(
            "\nThe coffee machine has:\n" +
                    "$_water ml of water\n" +
                    "$_milk ml of milk\n" +
                    "$_beans g of coffee beans\n" +
                    "$_cups disposable cups\n" +
                    "$$_money of money \n"
        )
    }

    private fun buy() {
        var coffeeType = ""

        println("\nWhat do you want buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        coffeeType = readln()
        when (coffeeType) {
            "1" -> check(coffeeType)
            "2" -> check(coffeeType)
            "3" -> check(coffeeType)
        }
    }

    private fun fill() {
        println("Write how many ml of water you want to add:")
        _water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        _milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        _beans += readln().toInt()
        println("Write how many disposable cups you want to add:")
        _cups += readln().toInt()

    }

    private fun take() {
        println("\nI gave you $$_money\n")
        _money = 0

    }

    private fun remaining() {
        printFinal()
    }

    private fun check(coffeeType: String) {
        if (coffeeType == "1") {
                when {
                    _water < 250 -> println("Sorry, not enough water!\n")
                    _beans < 16 -> println("Sorry, not enough beans!\n")
                    _cups < 1 -> println("Sorry, not enough cups!\n")
                    else -> make(coffeeType)
                }
        } else if (coffeeType == "2") {
                when {
                    _water < 350 -> println("Sorry, not enough water!\n")
                    _milk < 75 -> println("Sorry, not enough milk!\n")
                    _beans < 20 -> println("Sorry, not enough beans!\n")
                    _cups < 1 -> println("Sorry, not enough cups!\n")
                    else -> make(coffeeType)
                }
        } else if (coffeeType == "3") {
                when {
                    _water < 200 -> println("Sorry, not enough water!\n")
                    _milk < 100 -> println("Sorry, not enough milk!\n")
                    _beans < 12 -> println("Sorry, not enough beans!\n")
                    _cups < 1 -> println("Sorry, not enough cups!\n")
                    else -> make(coffeeType)
                }
        }
    }

    private fun make(coffeeType: String) {
        println("I have enough resources, making you a coffee!\n")
        when (coffeeType) {
            "1" -> {
                _water -= 250; _beans -= 16; _money += 4; _cups -= 1
            }

            "2" -> {
                _water -= 350; _milk -= 75; _beans -= 20; _money += 7; _cups -= 1
            }

            "3" -> {
                _water -= 200; _milk -= 100; _beans -= 12; _money += 6; _cups -= 1
            }
        }
    }
}