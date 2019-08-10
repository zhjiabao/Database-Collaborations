import pymysql
import numpy
import matplotlib.pyplot as plt


def main():
    com = pymysql.connect(host='localhost', user='root', password='root', db='student_exams')
    cur = com.cursor()
    cur.execute('SELECT * FROM performance')
    mathlist = []
    readinglist = []
    writinglist = []
    for c in cur:
        mathlist.append(c[6])
        readinglist.append(c[7])
        writinglist.append(c[8])
    mathaverage = numpy.mean(mathlist)
    mathstd = numpy.std(mathlist)
    readingaverage = numpy.mean(readinglist)
    readingstd = numpy.std(readinglist)
    writingaverage = numpy.mean(writinglist)
    writingstd = numpy.std(writinglist)
    plt.subplot(2, 1, 1)
    plt.plot(readinglist, mathlist, 'bo')
    plt.title('Math Scores and Writing Scores vs Reading Scores')
    plt.ylabel('Math Scores')
    plt.subplot(2, 1, 2)
    plt.plot(readinglist, writinglist, 'ro')
    plt.xlabel('Reading Scores')
    plt.ylabel('Writing Scores')
    plt.show()
    print("Math Average: " + mathaverage + " Math Standard Deviation: " + mathstd)
    print("Reading Average: " + readingaverage + " Reading Standard Deviation: " + readingstd)
    print("Writing Average: " + writingaverage + " Writing Standard Deviation: " + writingstd)
    com.close()


main()