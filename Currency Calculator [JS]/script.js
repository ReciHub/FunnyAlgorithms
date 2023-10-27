const inputTextField = document.getElementById('input')
const outputTextField = document.getElementById('output')
const inputCurrency = document.getElementById('inputCurrency')
const outputCurrency = document.getElementById('outputCurrency')

const currencyInfoList = []
let currentIndex = 0
let currencyInfo = {}

const convert = (val, rate) => {
  return val * rate
}

const checkForCurrencyInList = currency => {
  let isInList = false
  currencyInfoList.forEach((item, index) => {
    if (item.base_code == currency) {
      isInList = true
      currentIndex = index
    }
  })
  console.log('is in list: ', isInList, currentIndex)
  return isInList
}

document.getElementById('calcButton').addEventListener('click', () => {
  console.log('currently in list: ', currencyInfoList)
  const inVal = Number(inputTextField.value)

  // check if valid number
  if (!isNaN(inVal)) {
    console.log('Valid Number!')
    // check if currency info in cache, if not: fetch new currency data
    if (checkForCurrencyInList(inputCurrency.value)) {
      console.log('currency exists in list')
      currencyInfo = currencyInfoList[currentIndex]
    }

    if (currencyInfo.base_code != inputCurrency.value) {
      console.log('loading new data')
      fetch('https://open.er-api.com/v6/latest/' + inputCurrency.value)
        .then(response => {
          return response.json()
        })
        .then(result => {
          currencyInfoList.push(result)
          currencyInfo = result
          outputTextField.value = convert(
            inVal,
            currencyInfo.rates[outputCurrency.value]
          )
        })
        .catch(err => {
          outputTextField.value = "Couldn't fetch data. :-("
          console.log('ERROR:', err)
        })
      // if there's already matching currency info then no new fetch is neccessary
    } else {
      outputTextField.value = convert(
        inVal,
        currencyInfo.rates[outputCurrency.value]
      )
    }
  } else {
    outputTextField.value = "That's not a number. :-)"
  }
})
