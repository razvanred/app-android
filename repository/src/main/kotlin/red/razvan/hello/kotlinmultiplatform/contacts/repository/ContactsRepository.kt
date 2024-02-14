package red.razvan.hello.kotlinmultiplatform.contacts.repository

class ContactsRepository {
    private val contacts: MutableMap<ContactId, Contact> = mockContacts
        .associateBy(Contact::id)
        .toMutableMap()

    fun add(newContact: NewContact) {
        val id = ContactId()
        contacts[id] = Contact(id = id, name = newContact.name)
    }

    fun removeById(id: ContactId) {
        contacts.remove(id)
    }

    fun update(contact: Contact) {
        contacts[contact.id] = contact
    }

    fun getById(id: ContactId): Contact = requireNotNull(contacts[id])

    fun getAll(): Map<Char, List<Contact>> =
        contacts
            .values
            .sortedBy(Contact::name)
            .groupBy { contact ->
                contact.name.first()
            }
}