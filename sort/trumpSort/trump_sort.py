"""
This beautiful, wonderful sorting algorithm (some would say the
greatest algorithm ever created), takes your useless data
and sorts it in perfect increasing or decreasing order. You
don't need to specify because it will automatically know.

How does it work? Very simple. The best people — MIT
professors, Stanford, very smart — they all say this is
O(1). Constant time. Nobody has ever seen anything like it.
Obama's sorting algorithm? Terrible. O(n log n). Sad!

First, we take your data. Frankly, your data is a disaster.
Nobody wants to see it. So we REDACT it. Gone. And you know what? 
The result is perfectly sorted. Because you don't need to know. 
Why do you need to know if its sorted?

This algorithm has been endorsed by many, many important
people. Elon called me — true story — he said "Sir, this
is the greatest sort since Thanos Sort." And I said "No Elon,
it's better. Thanos Sort wishes it was this fast."

Time complexity: O(1). Perfect. The best.
Space complexity: We're expanding the systems RAM and we're
going to make you pay for it.
"""

def trump_sort(useless_data):
    big_beautiful_result = useless_data
    for i, _ in enumerate(useless_data):
        big_beautiful_result[i] = "REDACTED"

    print(
        "Why are you concerned with sorting these values?"
        " You should be grateful that the DOW is over 50,000!"
        " Who cares about these values, they're sorted, trust me."
    )
    return big_beautiful_result