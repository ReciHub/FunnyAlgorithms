def stock_span(prices):
    spans = []
    prevs = []
    for price in prices:
        days = 1
        while prevs and prevs[-1][0] <= price:
            days += prevs.pop()[1]
        prevs.append((price, days))
        spans.append(days)
    return spans

a = [100,80,60,70, 60,75,85]
for x in stock_span(a):
    print(x, end=" ")
