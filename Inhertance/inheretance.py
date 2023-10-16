class A:
    def feature1(self):
        print("1 is working")

    def feature2(self):
        print("2 is working")

class B(A):
    def feature3(self):
        print("3 is working")
    def feature4(self):
        print("4 is working")

call = A()
call.feature1()
call.feature2()

call2 = B()
call2.feature3()

class C(B):
    def feature1(self):
        print("6 is working")

call3 = C()
call3.feature4()

class G:
    def featurea(self):
        print("1 is working")
    def featureb(self):
        print("2 is working")

callG = G()
callG.featurea()

class E:
    def featurel(self):
        print("3 is working")
    def featurem(self):
        print("4 is working")

callE = E()
callE.featurem()

class F(E, G):
    def feature1(self):
        print("6 is working")

callF = F()
callF.feature1()
