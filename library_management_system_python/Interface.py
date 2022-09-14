import returnBook
import booksInLibrary
import dateAndTime
import rentBook

def start():
    while(True):
        print("***********************************")
        print("  Welcome to Wabi-Sabi bookstore   ")
        print("***********************************")
        print("\n -----Happy Reading----- \n")
        print("Enter 1: Display books available in the library: ")
        print("Enter 2: Rent a book: ")
        print("Enter 3: Return book: ")
        print("Enter 4: Exit: ")
        try:
            valueEntered = int(input("Select from option 1-4: "))
            print()
            if(valueEntered == 1):
                with open("library.txt", "r") as displayBooks:
                    lines = displayBooks.read()
                    print(lines)
                    print()    
            elif(valueEntered == 2):
                booksInLibrary.booksInLibrary()
                rentBook.rentBook()
            elif(valueEntered == 3):
                booksInLibrary.booksInLibrary()
                returnBook.returnBook()
            elif(valueEntered == 4):
                print("Thank you for choosing Wabi-Sabi bookstore")
            else:
                print("Invalid option! Please choose from option 1-4")
        except ValueError:
            print("Invalid Command! Try using option defined in the menu")
start()
