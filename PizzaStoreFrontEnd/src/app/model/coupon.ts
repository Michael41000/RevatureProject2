export class coupon {

    couponId: number;
    discountPercent: number;
    code: number;
    description: string

    constructor(couponId: number, discountPercent: number, code: number, description: string) {
        this.couponId = couponId;
        this.discountPercent = discountPercent;
        this.code = code;
        this.description = description;
    }

}