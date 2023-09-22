# Etiya-Java-Spring-Boot
<h1 align="center">Face Mask Detection</h1>

  <h4 align="center">Face Mask Detection System built with OpenCV, Keras/TensorFlow using Deep Learning and Computer Vision concepts in order to detect face masks in static images as well as in real-time video streams.</h4>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
![Python](https://img.shields.io/badge/python-v3.6+-red.svg)
[![Forks](https://img.shields.io/github/forks/bertuginal/Face-Mask-Detection.svg?logo=github)](https://github.com/bertuginal/Face-Mask-Detection/network/members)
[![Stargazers](https://img.shields.io/github/stars/bertuginal/Face-Mask-Detection.svg?logo=github)](https://github.com/bertuginal/Face-Mask-Detection/stargazers)

---

<div align="center"><img src="https://github.com/bertuginal/Face-Mask-Detection/blob/11843b8124b3467f5324997a690ce9fefcb73c2b/img/Face-mask.gif" width="500"></div>

## :star: Features
This system can be used in real-time applications that require face mask detection for security purposes due to the increase in the Covid-19 outbreak. This project can be integrated with embedded systems for application in airports, train stations, offices, schools and public places to ensure compliance with public safety guidelines.

## :file_folder: Dataset
The dataset used can be downloaded here - [Click to Download](https://github.com/bertuginal/Face-Mask-Detection/tree/master/Face-Mask-Detection/data)

This dataset consists of __5106 images__ belonging to two classes:
*	__with_mask: 3158 images__
*	__without_mask: 1948 images__

The images used were real images of faces wearing masks. The images were collected from the following sources:

* __Kaggle datasets__ 
* __Various videos__
* __Udemy tutorials__


## :warning: Libraries used

- [OpenCV](https://opencv.org/)
- [Keras](https://keras.io/)
- [TensorFlow](https://www.tensorflow.org/)
- [Numpy](https://numpy.org)
- [Sklearn](https://scikit-learn.org/)
- [Matplotlib](https://matplotlib.org)
- [Imutils](https://pypi.org/project/imutils/)
- [Os](https://pypi.org/project/os-sys/)

## :warning: Haar-cascade used
It is a method applied to find objects on the image. This method is called haar-like features. I used the "[haarcascade_frontalface_default.xml](https://github.com/bertuginal/Face-Mask-Detection/blob/master/Face-Mask-Detection/data/haarcascade_frontalface_default.xml)" file in this project.

You can download all the haarcascade xml files you need from [here](https://github.com/opencv/opencv/tree/master/data/haarcascades).

## 🚀&nbsp; Installation
1. Clone the repo
```
$ git clone https://github.com/bertuginal/Face-Mask-Detection.git
```
2. Now, run the following command in your Terminal/Command Prompt to install the libraries required
```
$ pip3 install -r requirements.txt
```

## :bulb: Working

1. Open terminal. Type the following command to train the model:
```
$ python3 Train.py --dataset data
```

2. To detect face masks in real-time video streams type the following command:
```
$ python3 Test.py 
```
## :key: Results

<h4 align="center"> My model gave 98% accuracy for Face Mask Detection after training via <code>tensorflow-gpu==2.5.0</code> </h4>

####          
<div align="center"><img src="https://github.com/bertuginal/Face-Mask-Detection/blob/dd383d0bc96cd6ab9d15823f96756e89df7623f7/img/train-cmd.png" width="500"></div>

---

<h4 align="center"> I got the following accuracy/loss training curve plot.</h4>

<div align="center"><img src="https://github.com/bertuginal/Face-Mask-Detection/blob/4a8151b8c1ed169b2d1c1d795c2c4e91695f4d67/img/graphic.png" width="500"></div>

## :point_down: Images

<h3 align="center"> FRAME: With Mask</h3>
<h4 align="center">I got 98.85% accuracy when wearing a face mask.</h4>
<br>
<div align="center"><img src="https://github.com/bertuginal/Face-Mask-Detection/blob/09241e369c708898dd197a3ede1c9592183ca614/img/withmask.jpg" width="700"></div>

---

<h3 align="center"> FRAME: Without Mask</h3>
<h4 align="center">I got 99.77% accuracy when we were not wearing a face mask.</h4>
<br>
<div align="center"><img src="https://github.com/bertuginal/Face-Mask-Detection/blob/09241e369c708898dd197a3ede1c9592183ca614/img/withoutmask.jpg" width="700"></div>

---

<h3 align="center"> FRAME: Half With Mask</h3>
<h4 align="center">I got 53.06% accuracy when the face mask is worn under the mouth.</h4>
<br>
<div align="center"><img src="https://github.com/bertuginal/Face-Mask-Detection/blob/09241e369c708898dd197a3ede1c9592183ca614/img/half-withmask.jpg" width="700"></div>

## :clap: And it's done!
Feel free to mail me for any doubts/query :email: bertuginal@yahoo.com

:star: <b>If you like my project, can you click the star to support me?</b>
