# tesseract-web

## Install

* [tesseract](https://github.com/tesseract-ocr/tesseract)
* [jpn.traineddata](https://github.com/tesseract-ocr/tessdata/blob/3.04.00/jpn.traineddata)

```
brew install tesseract
git clone https://github.com/223kazuki/tesseract-web.git
cd tesseract-web
wget https://github.com/tesseract-ocr/tessdata/raw/3.04.00/jpn.traineddata
mkdir tessdata/
mv jpn.traineddata tessdata/
```

## Run

```
lein run
```