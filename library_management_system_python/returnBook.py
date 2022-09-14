import booksInLibrary
import dateAndTime

def returnBook():
    fname = input("Enter name of borrower: ")
    a = "Borrow-"+fname+".txt"
    try:
        with open(a, "r") as f:
            readFile = f.read()
            print(readFile)
    except FileNotFoundError:
        print("Error! \n Name of borrower is not in the list!")
        returnBooks()

    b= "ReturnedBy-"+fname+".txt"
    with open(b, "w+")as f:
        f.write("\t             Wabisabi Library\n")
        f.write("\t Returned by: " + fname + "\n")
        f.write("Date: " + dateAndTime.getDate()+"    Time:" + dateAndTime.getTime()+"\n\n")
        f.write("S.N.\t\tBookname\t\tCost\n")

    totalBill = 0.0
    for i in range(3):
        if booksInLibrary.nameOfBook[i] in readFile:
            with open(b, "a") as f:
                f.write(str(i+1)+"\t\t"+booksInLibrary.nameOfBook[i]+"\t\t$"+booksInLibrary.costOfBook[i]+"\n")
                booksInLibrary.bookQuantity[i]=int(booksInLibrary.bookQuantity[i])+1
            totalBill += float(booksInLibrary.costOfBook[i])
            
    print("\t\t\t\t\t\t\t"+"$"+str(totalBill))
    print("Is book is returned late?")
    print("Press Y or N!")
    condition = input()
    if(condition.upper() == "Y"):
        print("By how many days?")
        dateLate = int(input())
        lateFine = 2*dateLate
        with open(b, "a")as f:
            f.write("\t\t\t\t\tFine: $" + str(lateFine)+"\n")
        totalBill=totalBill+lateFine

    print("Final Total: " + "$"+str(totalBill))
    with open(b, "a")as f:
        f.write("\t\t\t\t\tTotal: $" + str(totalBill))

    with open("library.txt", "w+") as f:
        for i in range(3):
            f.write(booksInLibrary.nameOfBook[i]+","+booksInLibrary.nameOfAuthor[i]+","+str(
                booksInLibrary.bookQuantity[i])+","+"$"+booksInLibrary.costOfBook[i]+"\n")

