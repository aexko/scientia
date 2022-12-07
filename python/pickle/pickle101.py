import pickle
from expertise import Expertise
import sys

# example_dict = {1:"6",2:"2",3:"f"}

# pickle_out = open("dict.pickle","wb") # wb = write binary
# pickle.dump(example_dict, pickle_out)
# pickle_out.close()

# pickle_in = open("dict.pickle","rb") # rb = read binary
# example_dict = pickle.load(pickle_in)
# print(example_dict)
# print(example_dict[2])
# print(example_dict[3])

def openPickle(filename):
    pickle_in = open(filename,"rb") # rb = read binary
    output = pickle.load(pickle_in)
    print(output)
    
openPickle("floor_and_walls1.pickle")

print(sys.getrecursionlimit())