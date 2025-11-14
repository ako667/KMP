# KMP String Search Algorithm — Report

## 1. Introduction

This report describes the implementation, testing, and complexity analysis of the Knuth–Morris–Pratt (KMP) string-search algorithm developed in Java.  
The purpose of this assignment is to implement a classical efficient pattern-matching algorithm from scratch, test it on strings of different lengths, and analyze the performance characteristics.

KMP improves upon the naive string-search approach by eliminating redundant comparisons using a precomputed prefix table (LPS — Longest Prefix Suffix).  
The algorithm operates in linear time with respect to the lengths of the text and the pattern, making it significantly more efficient for long inputs.

---

## 2. Algorithm Description

The KMP algorithm consists of two main stages:

### 2.1 LPS Array Construction
Before searching the pattern in the text, KMP computes an array called **LPS (Longest Prefix Suffix)**.

- `lps[i]` = length of the longest proper prefix of the pattern  
  that is also a suffix ending at index `i`
- This table enables the algorithm to skip characters without re-checking them
- LPS construction requires **O(m)** time, where *m* is the pattern length

### 2.2 Main Search Procedure
The search scans the text from left to right while comparing it to the pattern.

- When characters match → move forward in both text and pattern
- When characters mismatch:
  - instead of restarting the pattern from index 0
  - KMP uses the LPS array to shift the pattern more intelligently

This avoids redundant comparisons and ensures linear time complexity.

---

## 3. Implementation Summary

The implementation contains two major methods:

### ✔ `buildLPS(pattern)`
- Returns an integer array of length equal to the pattern
- Computes prefix information in **O(m)** time
- Uses two pointers:  
  `i` (current position) and `prefixLen` (prefix length)

### ✔ `search(text, pattern)`
- Searches for the first occurrence of `pattern` in `text`
- Runs in **O(n)** time for text length *n*
- Uses two indices:  
  `i` for the text, `j` for the pattern

The final return value is the starting index of the match or `-1` if not found.

The code is fully commented to make the logic clear.

---

## 4. Testing and Results

Testing was performed using three examples:

### **4.1 Short String**
- Text: `"abcde"`
- Pattern: `"cd"`
- Expected Result: index **2**
- Actual Result: **2**

### **4.2 Medium-Length String**
- Text: `"the quick brown fox jumps over the lazy dog"`
- Pattern: `"brown"`
- Expected Result: index **10**
- Actual Result: **10**

### **4.3 Long String (≈100,000 characters)**
- Text: `"abcabcabcd"` repeated 10,000 times + `"TARGET"`
- Pattern: `"TARGET"`
- Expected Result: index ≈ **100000**
- Actual Result: **100000**

#### Performance observation:
- Long input executed in **well under 1 millisecond**
- The execution time grows linearly as expected
- The LPS array ensures that performance remains stable even on repeated patterns

---

## 5. Time and Space Complexity Analysis

### **5.1 Time Complexity**

| Stage                         | Complexity |
|-------------------------------|------------|
| LPS Array Construction        | O(m)       |
| Main String Search            | O(n)       |
| **Total Time Complexity**     | **O(n + m)** |

Where:  
- *n* = text length  
- *m* = pattern length  

This is optimal for exact substring searching, and no redundant comparisons occur.

---

### **5.2 Space Complexity**

| Structure                     | Space Usage |
|-------------------------------|-------------|
| LPS Array                     | O(m)        |
| Constant auxiliary variables  | O(1)        |
| **Total Space Complexity**    | **O(m)**    |

This makes KMP more space-efficient than automaton-based algorithms like Aho–Corasick.

---

## 6. Conclusion

The Knuth–Morris–Pratt algorithm was implemented successfully from scratch in Java.  
Testing across short, medium, and long inputs demonstrates that the algorithm performs efficiently under all conditions due to its linear time complexity.

Key takeaways:

- KMP avoids redundant comparisons using the LPS table
- Total time complexity is **O(n + m)**
- Space complexity is **O(m)**
- Works extremely well on long, repetitive input where naive search would be slow
- The Java implementation is clean, readable, and fully commented

This project confirms that KMP is a highly efficient and practical method for substring matching tasks and performs consistently across varying input sizes.

