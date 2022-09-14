import dateAndTime
import booksInLibrary


def rentBook():
    rent = False
    while(True):
        fName = input("Enter the first name of the borrower: ")
        if fName.isalpha():
            break
        print("please input alphabet from A-Z")
    while(True):
        lName = input("Enter the last name of the borrower: ")
        if lName.isalpha():
            break
        print("please input alphabet from A-Z")

    t = "Borrow-"+fName+".txt"
    with open(t, "w+") as f:
        f.write("               WabiSabi Library  \n")
        f.write("                   Borrowed By: " +
                fName+" "+lName+"\n")
        f.write("    Date: " + dateAndTime.getDate()+"    Time:" + dateAndTime.getTime()+"\n\n")
        f.write("S.N. \t\t Bookname \t      Authorname \n")

    while rent == False:
        print("Please select a option below:")
        for i in range(len(booksInLibrary.nameOfBook)):
            print("Enter", i, "to borrow book", booksInLibrary.nameOfBook[i])

        try:
            a = int(input())
            try:
                if(int(booksInLibrary.bookQuantity[a]) > 0):
                    print("Book is available")
                    with open(t, "a") as f:
                        f.write(
                            "1. \t\t" + booksInLibrary.nameOfBook[a]+"\t\t  "+booksInLibrary.nameOfAuthor[a]+"\n")

                    booksInLibrary.bookQuantity[a] = int(booksInLibrary.bookQuantity[a])-1
                    with open("library.txt", "w+") as f:
                        for i in range(3):
                            f.write(booksInLibrary.nameOfBook[i]+","+booksInLibrary.nameOfAuthor[i]+","+str(
                                booksInLibrary.bookQuantity[i])+","+"$"+booksInLibrary.costOfBook[i]+"\n")

 #For borrowing multiple books
                    multiple = True
                    count = 1
                    while multiple == True:
                        optionMultipleBooks = str(input(
                            "Do you want to borrow more books? However you cannot borrow same book twice. Press y for yes and n for no."))
                        if(optionMultipleBooks.upper() == "Y"):
                            count = count+1
                            print("Please select an option below:")
                            for i in range(len(booksInLibrary.nameOfBook)):
                                print("Enter", i, "to borrow book",
                                      booksInLibrary.nameOfBook[i])
                            a = int(input())
                            if(int(booksInLibrary.bookQuantity[a]) > 0):
                                print("Book is available")
                                with open(t, "a") as f:
                                    f.write(str(
                                        count) + ". \t\t" + booksInLibrary.nameOfBook[a]+"\t\t  "+booksInLibrary.nameOfAuthor[a]+"\n")

                                booksInLibrary.bookQuantity[a] = int(
                                    booksInLibrary.bookQuantity[a])-1
                                with open("library.txt", "w+") as f:
                                    for i in range(3):
                                        f.write(booksInLibrary.nameOfBook[i]+","+booksInLibrary.nameOfAuthor[i]+","+str(
                                            booksInLibrary.bookQuantity[i])+","+"$"+booksInLibrary.costOfBook[i]+"\n")
                                        rent = False
                            else:
                                multiple = False
                                break
                        elif (optionMultipleBooks.upper() == "N"):
                            print("Thank you for borrowing books from us. ")
                            print("")
                            multiple = False
                            rent = True
                        else:
                            print("Please choose as instructed")

                else:
                    print("Book is not available")
                    rentBook()
                    rent = False
            except IndexError:
                print("")
                print("Please choose book acording to their number.")
        except ValueError:
            print("")
            print("Please choose as suggested.")
