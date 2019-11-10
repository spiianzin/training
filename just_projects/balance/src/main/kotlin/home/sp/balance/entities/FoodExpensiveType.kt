package home.sp.balance.entities

class FoodExpensiveType : ExpensiveType {
    override fun name() : String {
        return "Food"
    }

    override fun colour() : String {
        return "Red"
    }
}