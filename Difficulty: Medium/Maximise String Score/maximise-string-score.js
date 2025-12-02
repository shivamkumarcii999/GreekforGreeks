class Solution {
  maxScore(s, jumps) {
    const n = s.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] + s.charCodeAt(i);
    }
    const charPrefix = Array.from({ length: 26 }, () =>
      new Array(n + 1).fill(0)
    );
    for (let i = 0; i < n; i++) {
      const c = s.charCodeAt(i) - 97;
      for (let ch = 0; ch < 26; ch++) {
        charPrefix[ch][i + 1] = charPrefix[ch][i];
      }
      charPrefix[c][i + 1] += s.charCodeAt(i);
    }
    const canJump = Array.from({ length: 26 }, () => new Array(26).fill(false));
    for (let i = 0; i < 26; i++) {
      canJump[i][i] = true; // same character jumps
    }
    for (const [from, to] of jumps) {
      const src = from.charCodeAt(0) - 97;
      const dest = to.charCodeAt(0) - 97;
      canJump[src][dest] = true;
    }
    const best = Array.from({ length: 26 }, () =>
      new Array(26).fill(-Infinity)
    );
    const dp = new Array(n).fill(-Infinity);
    dp[0] = 0;
    const firstChar = s.charCodeAt(0) - 97;
    for (let dest = 0; dest < 26; dest++) {
      best[firstChar][dest] = 0 - prefix[0] + charPrefix[dest][0]; // 0 - 0 + 0 = 0
    }
    for (let i = 1; i < n; i++) {
      const currChar = s.charCodeAt(i) - 97;
      let maxVal = -Infinity;
      for (let src = 0; src < 26; src++) {
        if (canJump[src][currChar] && best[src][currChar] !== -Infinity) {
          maxVal = Math.max(maxVal, best[src][currChar]);
        }
      }
      if (maxVal !== -Infinity) {
        dp[i] = maxVal + (prefix[i] - charPrefix[currChar][i]);
      }
      if (dp[i] !== -Infinity) {
        for (let dest = 0; dest < 26; dest++) {
          const val = dp[i] - prefix[i] + charPrefix[dest][i];
          if (val > best[currChar][dest]) {
            best[currChar][dest] = val;
          }
        }
      }
    }
    return Math.max(0, ...dp);
  }
}