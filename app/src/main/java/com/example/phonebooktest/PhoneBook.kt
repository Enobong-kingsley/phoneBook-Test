package com.example.phonebooktest

fun main() {
    val firstPhoneNumber = PhoneNumber(
        name = "Kingsley",
        email = "king@gmail.com",
    )

    val secondPhoneNumber = PhoneNumber(
        name = "James Bond",
        email = "jamesbond@gmail.com",
    )

    val phoneBook = PhoneBook()
    phoneBook.storePhoneNumber(phoneNumbers = listOf(firstPhoneNumber, secondPhoneNumber))
    phoneBook.storePhoneNumber(phoneNumber = firstPhoneNumber)

    println("phoneNumbers are ${phoneBook.phoneNumbers}")
    println("phoneNumber details are ${phoneBook.getPhoneNumberDetails(name = firstPhoneNumber.name, email = null)}")
}


data class PhoneNumber(
    val name: String,
    val email: String,
    val dateCreated: Long = System.currentTimeMillis()
)

class PhoneBook {

    private val _phoneNumbers = mutableSetOf<PhoneNumber>()
    val phoneNumbers get() = _phoneNumbers.toList()

    fun storePhoneNumber(phoneNumber: PhoneNumber) {
        _phoneNumbers.add(phoneNumber)
    }

    fun storePhoneNumber(phoneNumbers: List<PhoneNumber>) {
        _phoneNumbers.addAll(phoneNumbers)
    }

    fun getPhoneNumberDetails(name: String?, email: String?): PhoneNumber? {
        if(name == null && email == null) return null
        return _phoneNumbers.first { it.name == name || it.email == email }
    }
}