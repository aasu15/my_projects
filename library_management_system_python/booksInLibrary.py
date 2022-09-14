def booksInLibrary():
    global nameOfBook
    global nameOfAuthor
    global bookQuantity
    global costOfBook
    nameOfBook = []
    nameOfAuthor = []
    bookQuantity = []
    costOfBook = []
    with open("library.txt", "r") as displayBooks:
        lines = displayBooks.readlines()
        lines = [x.strip("\n") for x in lines]
        for i in range(len(lines)):
            varX = 0
            for varY in lines[i].split(","):
                if(varX == 0):
                    nameOfBook.append(varY)
                elif(varX == 1):
                    nameOfAuthor.append(varY)
                elif(varX == 2):
                    bookQuantity.append(varY)
                elif(varX==3):
                    costOfBook.append(varY.strip("$"))
                varX +=1
