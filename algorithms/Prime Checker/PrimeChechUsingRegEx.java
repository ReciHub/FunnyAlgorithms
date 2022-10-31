public static boolean isPrime(int n) {
    return !new String(new char[n]).matches(".?|(..+?)\\1+");
}
