""" Scans a stockpile screenshot and tries to work out what is contained """

import cv2
import numpy
import os
import pytesseract
import sys

ITEMS = {
    '7.92mm ammo': 'images/smallarms/7.92mm.jpg',
    'Aalto Storm Rifle 24': 'images/smallarms/aalto.jpg',
    '68mm AT ammo': 'images/explosives/68mm.png',
}

def scan(screenshot: str):
    screenshot_data = cv2.imread(screenshot, cv2.IMREAD_GRAYSCALE)
    for name, img in ITEMS.items():
        match_data = cv2.imread(os.path.join(os.path.dirname(__file__), img), cv2.IMREAD_GRAYSCALE)
        h, w = match_data.shape
        result = cv2.matchTemplate(screenshot_data, match_data, cv2.TM_CCOEFF_NORMED)
        threshold = .85
        loc = numpy.where(result >= threshold)
        for pt in zip(*loc[::-1]):
            cropped = screenshot_data[pt[1] + h - 2:pt[1] + h + 30, pt[0] - 2:pt[0] + w + 2]
            num = pytesseract.image_to_string(cropped)
            try:
                print(f"{name}: {int(num)}")
                break
            except ValueError:
                continue

def main():
    scan(os.path.abspath(sys.argv[1]))