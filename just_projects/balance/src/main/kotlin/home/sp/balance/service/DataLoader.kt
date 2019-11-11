package home.sp.balance.service

interface DataLoader<S, T> {
    fun load(source: S)
}