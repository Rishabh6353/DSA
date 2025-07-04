import string
import random

def generate_variants(base_code, limit=10):
    """
    Keep 'SUNCOIN' fixed and generate up to 10 variations
    by mutating characters in the suffix (e.g., '200NIF').
    """
    fixed_prefix = "SUNCOIN"
    suffix = base_code[len(fixed_prefix):]
    charset = string.ascii_uppercase
    digits = "0123456789"
    variants = set()

    while len(variants) < limit:
        new_suffix = ""
        for ch in suffix:
            if ch.isalpha():
                shift = random.randint(1, 3)
                idx = charset.index(ch.upper())
                new_ch = charset[(idx + shift) % len(charset)]
            elif ch.isdigit():
                shift = random.randint(1, 2)
                idx = digits.index(ch)
                new_ch = digits[(idx + shift) % len(digits)]
            else:
                new_ch = ch  # Leave untouched if neither digit nor alpha
            new_suffix += new_ch
        new_code = fixed_prefix + new_suffix
        if new_code != base_code:
            variants.add(new_code)

    return list(variants)

# Example usage
base = "SUNCOIN200NIF"
codes = generate_variants(base, limit=10)
for c in codes:
    print(c)
