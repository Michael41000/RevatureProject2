export class coupon {

    couponId: number;
    discountPercent: number;
    code: number;
    description: string;
    active: boolean;

    constructor(couponId: number, discountPercent: number, code: number, description: string, active: boolean) {
        this.couponId = couponId;
        this.discountPercent = discountPercent;
        this.code = code;
        this.description = description;
        this.active = active;
    }

}