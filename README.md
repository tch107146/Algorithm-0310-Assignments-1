# Assignment 1: Weighted Interval Scheduling (Greedy vs. DP)

本專案為國立澎湖科技大學資訊工程學系「演算法」課程之第一次程式作業，主要探討與實作**帶權重區間排程問題（Weighted Interval Scheduling）**。

## 📝 專案說明

傳統的活動選擇問題（Activity Selection Problem）為貪婪演算法（Greedy Algorithm）的經典應用。然而，當各個活動加入不同的權重（價值）後，單純依賴貪婪策略（如：選擇最早結束的活動）將無法保證找到全域最佳解。

本程式以 Java 實作了兩種解法來進行對比：
1. **Greedy Strategy**: 依結束時間排序後，依序挑選不重疊的活動。
2. **Dynamic Programming (DP)**: 結合二元搜尋（Binary Search）尋找不重疊的最近活動 $p(j)$，利用狀態轉移方程式保證找出最大總價值，時間複雜度為 $O(n \log n)$。

## 📂 檔案結構

* `WeightedIntervalScheduling.java`: 演算法核心程式碼。
* `Algorithm-0310-Assignments-1.tex`: IEEE 格式的實驗觀察報告原始碼。
* `screenshot.png`: 程式執行之終端機輸出截圖。

## 🚀 如何執行

請確保你的環境中已安裝 Java Development Kit (JDK)。

1. **編譯程式碼**：
   ```bash
   Algorithm_0310_Assignments_1.java

2. **執行程式**：
    ```bash
    java Algorithm_0310_Assignments_1

## 📊 預期輸出
針對教材中的測試資料，程式將輸出以下結果，並印出時間複雜度分析：

    Assignment 1: Greedy vs DP

    Greedy Selected: A D H 

    Greedy Total Value: 13

    DP Optimal Total Value: 13

    Time Complexity Analysis:

    - Sorting: O(n log n)

    - DP with Binary Search: O(n log n)