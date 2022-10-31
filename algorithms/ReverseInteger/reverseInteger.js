const reverse = integer =>
    parseInt(
        integer
            .toString()
            .split("")
            .reverse()
            .join("")
    ) * Math.sign(integer);
