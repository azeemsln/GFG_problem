//{ Driver Code Starts
// Initial Template for javascript

"use strict";

process.stdin.resume();
process.stdin.setEncoding("utf-8");

let inputString = "";
let currentLine = 0;

process.stdin.on("data", (inputStdin) => { inputString += inputStdin; });

process.stdin.on("end", (_) => {
    inputString =
        inputString.trim().split("\n").map((string) => { return string.trim(); });

    main();
});

function readLine() { return inputString[currentLine++]; }

function main() {
    let t = parseInt(readLine());
    let i = 0;

    for (; i < t; i++) {
        let n = parseInt(readLine());
        let arr = readLine().trim().split(" ").map((x) => parseInt(x));
        let obj = new Solution();
        let res = obj.maxXOR(arr);
        console.log(res);

        console.log("~");
    }
}
// } Driver Code Ends


// User function Template for javascript

/**
 * @param {number[]} arr
 * @return {number}
 */

class TrieNode {
    constructor() {
        this.children = {};
    }
}

class Solution {
    maxXOR(arr) {
        const root = new TrieNode();
        let max = 0;

        const insert = (num) => {
            let node = root;
            for (let i = 31; i >= 0; i--) {
                let bit = (num >> i) & 1;
                if (!node.children[bit]) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        };

        const findMaxXOR = (num) => {
            let node = root;
            let currXOR = 0;
            for (let i = 31; i >= 0; i--) {
                let bit = (num >> i) & 1;
                let toggledBit = 1 - bit;
                if (node.children[toggledBit]) {
                    currXOR |= (1 << i);
                    node = node.children[toggledBit];
                } else {
                    node = node.children[bit];
                }
            }
            return currXOR;
        };

        for (let num of arr) {
            insert(num);
        }

        for (let num of arr) {
            max = Math.max(max, findMaxXOR(num));
        }

        return max;
    }
}

