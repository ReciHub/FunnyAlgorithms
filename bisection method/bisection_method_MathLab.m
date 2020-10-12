%For Ecuation x^4 + 3*x^3 - 2
clc; clear;
xa = input('Enter a value for a : ');
xb = input('Enter a value for b: ');
Ep_User = input('Enter minimal porcentage of error %: '); %The smaller the number it will consume more time

%xb = 1;
%xa = 0;
xra= 0;
EP = 100;
IT = 1;
fprintf('IT   xr    fxa    fxr    fxar    Ep  \n') 

while EP >= Ep_User
xr = (xa + xb )/ 2;
fxa= xa^4 + 3*xa^3 - 2; % Here you enter the ecuation you are using
fxr= xr^4 + 3*xr^3 - 2; % Here you enter the ecuation you are using
fxar = fxr*fxa;
    if fxar < 0 
    xb = xr;
    else 
    xa = xr;
    end
 EP = abs(((xr-xra)/xr)*100);
 fprintf('%i %.4f %.4f %.4f %.4f %.4f \n',IT, xr, fxa, fxr, fxar, EP)
 xra = xr;
 IT =  IT + 1;
end
