export class GroupieBuilder {
    section:any;
    currentSection: any;
    constructor() {
        this.section = {};
    }

    withSection(id: string): GroupieBuilder {
        this.currentSection = { id };
        this.section[id] = this.currentSection;
        return this;
    }
    updateSection(key: string, obj: any) : GroupieBuilder {
        this.currentSection[key] = obj;
        return this;
    }

    addItem(obj: any): GroupieBuilder {
        if (!this.currentSection["items"]) {
            this.currentSection["items"] = [];
        }
        this.currentSection["items"].push(obj);
        return this;
    }
    addItems(objArr: Array<any>): GroupieBuilder {
        if (!this.currentSection["items"]) {
            this.currentSection["items"] = [];
        }
        for (var obj in objArr) {
            this.currentSection["items"].push(obj);
        }
        return this;
    }

    getSectionData(): any {
        return this.section;
    }
}