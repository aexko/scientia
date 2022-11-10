const sum = require("./sum");

describe('testing tests', () => {
    test("adds 1 + 2 to equal 3", () => {
        expect(sum(1, 2)).toBe(3);
    });
    
    it('should add 1 + 2 to equals 3', () => {
        const result = sum(1,3);
        expect(result).toBe(4);
    });
    // toBe VS toEquals
    // fails even if obj is empty because two objects is not the same, they have different id
    it('object assignment', () => {
        const obj = {};
        expect(obj).toBe({});
    })
})
