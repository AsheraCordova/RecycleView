// start - imports

	
import CommandAttr from '../../widget/CommandAttr';
import IWidget from '../../widget/IWidget';
import ILayoutParam from '../../widget/ILayoutParam';
import {plainToClass, Type, Exclude, Expose, Transform} from "class-transformer";
import 'babel-polyfill';
import {Gravity} from '../../widget/TypeConstants';
import {ITranform, TransformerFactory} from '../../widget/TransformerFactory';
import {Event} from '../../app/Event';
import {MotionEvent} from '../../app/MotionEvent';
import {DragEvent} from '../../app/DragEvent';
import {KeyEvent} from '../../app/KeyEvent';
import { ScopedObject } from '../../app/ScopedObject';






export class RecyclerViewImpl_addSectionItem {
@Expose({ name: "sectionId" })
sectionId!:string;
@Expose({ name: "itemConfigId" })
itemConfigId!:string;
@Expose({ name: "item" })
item!:any;
}
export class RecyclerViewImpl_removeSectionItem {
@Expose({ name: "sectionId" })
sectionId!:string;
@Expose({ name: "itemConfigId" })
itemConfigId!:string;
@Expose({ name: "itemId" })
itemId!:string;
}
export class RecyclerViewImpl_removeAllItems {
@Expose({ name: "sectionId" })
sectionId!:string;
}
export class RecyclerViewImpl_updateSectionItem {
@Expose({ name: "sectionId" })
sectionId!:string;
@Expose({ name: "itemConfigId" })
itemConfigId!:string;
@Expose({ name: "itemId" })
itemId!:string;
@Expose({ name: "item" })
item!:any;
}












import {ViewGroupImpl_LayoutParams} from './ViewGroupImpl';

// end - imports
import {ViewGroupImpl} from './ViewGroupImpl';
export abstract class RecyclerViewImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
    }	
	@Type(() => CommandAttr)
	@Expose({ name: "layoutManager" })
	layoutManager!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "viewHolderIds" })
	viewHolderIds!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "spanCount" })
	spanCount!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "layout" })
	layout!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "nestedScrollingEnabled" })
	nestedScrollingEnabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "addSectionItem" })
	addSectionItem_!:CommandAttr<RecyclerViewImpl_addSectionItem>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "removeSectionItem" })
	removeSectionItem_!:CommandAttr<RecyclerViewImpl_removeSectionItem>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "removeAllItems" })
	removeAllItems_!:CommandAttr<RecyclerViewImpl_removeAllItems>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "updateSectionItem" })
	updateSectionItem_!:CommandAttr<RecyclerViewImpl_updateSectionItem>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "stackFromEnd" })
	stackFromEnd!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "reverseLayout" })
	reverseLayout!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollToEnd" })
	scrollToEnd_!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollToTop" })
	scrollToTop_!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "scrollToPosition" })
	scrollToPosition_!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "swtIncrement" })
	swtIncrement!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "nestedScrollStopDelay" })
	nestedScrollStopDelay!:CommandAttr<number>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onScrollStateChange" })
	onScrollStateChange!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "onScrolled" })
	onScrolled!:CommandAttr<string>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "headerDisabled" })
	headerDisabled!:CommandAttr<boolean>| undefined;
	@Type(() => CommandAttr)
	@Expose({ name: "footerDisabled" })
	footerDisabled!:CommandAttr<boolean>| undefined;

	@Exclude()
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.layoutManager = undefined;
		this.viewHolderIds = undefined;
		this.spanCount = undefined;
		this.layout = undefined;
		this.nestedScrollingEnabled = undefined;
		this.addSectionItem_ = undefined;
		this.removeSectionItem_ = undefined;
		this.removeAllItems_ = undefined;
		this.updateSectionItem_ = undefined;
		this.stackFromEnd = undefined;
		this.reverseLayout = undefined;
		this.scrollToEnd_ = undefined;
		this.scrollToTop_ = undefined;
		this.scrollToPosition_ = undefined;
		this.swtIncrement = undefined;
		this.nestedScrollStopDelay = undefined;
		this.onScrollStateChange = undefined;
		this.onScrolled = undefined;
		this.headerDisabled = undefined;
		this.footerDisabled = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setLayoutManager(value : string) : T {
		this.resetIfRequired();
		if (this.layoutManager == null || this.layoutManager == undefined) {
			this.layoutManager = new CommandAttr<string>();
		}
		
		this.layoutManager.setSetter(true);
		this.layoutManager.setValue(value);
		this.orderSet++;
		this.layoutManager.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setViewHolderIds(value : string) : T {
		this.resetIfRequired();
		if (this.viewHolderIds == null || this.viewHolderIds == undefined) {
			this.viewHolderIds = new CommandAttr<string>();
		}
		
		this.viewHolderIds.setSetter(true);
		this.viewHolderIds.setValue(value);
		this.orderSet++;
		this.viewHolderIds.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSpanCount(value : number) : T {
		this.resetIfRequired();
		if (this.spanCount == null || this.spanCount == undefined) {
			this.spanCount = new CommandAttr<number>();
		}
		
		this.spanCount.setSetter(true);
		this.spanCount.setValue(value);
		this.orderSet++;
		this.spanCount.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setLayout(value : string) : T {
		this.resetIfRequired();
		if (this.layout == null || this.layout == undefined) {
			this.layout = new CommandAttr<string>();
		}
		
		this.layout.setSetter(true);
		this.layout.setValue(value);
		this.orderSet++;
		this.layout.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetNestedScrollingEnabled() : T {
		this.resetIfRequired();
		if (this.nestedScrollingEnabled == null || this.nestedScrollingEnabled == undefined) {
			this.nestedScrollingEnabled = new CommandAttr<boolean>()
		}
		
		this.nestedScrollingEnabled.setGetter(true);
		this.orderGet++;
		this.nestedScrollingEnabled.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isNestedScrollingEnabled() : boolean {
		if (this.nestedScrollingEnabled == null || this.nestedScrollingEnabled == undefined) {
			this.nestedScrollingEnabled = new CommandAttr<boolean>();
		}
		return this.nestedScrollingEnabled.getCommandReturnValue();
	}
	public setNestedScrollingEnabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.nestedScrollingEnabled == null || this.nestedScrollingEnabled == undefined) {
			this.nestedScrollingEnabled = new CommandAttr<boolean>();
		}
		
		this.nestedScrollingEnabled.setSetter(true);
		this.nestedScrollingEnabled.setValue(value);
		this.orderSet++;
		this.nestedScrollingEnabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public addSectionItem(sectionId : string,
itemConfigId : string,
item : any) : T {
		this.resetIfRequired();
		if (this.addSectionItem_ == null || this.addSectionItem_ == undefined) {
			this.addSectionItem_ = new CommandAttr<RecyclerViewImpl_addSectionItem>();
		}
		
		let wrapper:RecyclerViewImpl_addSectionItem = new RecyclerViewImpl_addSectionItem();
		wrapper.sectionId = sectionId;
		wrapper.itemConfigId = itemConfigId;
		wrapper.item = item;
		this.addSectionItem_.setSetter(true);
		this.addSectionItem_.setValue(wrapper);	
		this.orderSet++;
		this.addSectionItem_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public removeSectionItem(sectionId : string,
itemConfigId : string,
itemId : string) : T {
		this.resetIfRequired();
		if (this.removeSectionItem_ == null || this.removeSectionItem_ == undefined) {
			this.removeSectionItem_ = new CommandAttr<RecyclerViewImpl_removeSectionItem>();
		}
		
		let wrapper:RecyclerViewImpl_removeSectionItem = new RecyclerViewImpl_removeSectionItem();
		wrapper.sectionId = sectionId;
		wrapper.itemConfigId = itemConfigId;
		wrapper.itemId = itemId;
		this.removeSectionItem_.setSetter(true);
		this.removeSectionItem_.setValue(wrapper);	
		this.orderSet++;
		this.removeSectionItem_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public removeAllItems(sectionId : string) : T {
		this.resetIfRequired();
		if (this.removeAllItems_ == null || this.removeAllItems_ == undefined) {
			this.removeAllItems_ = new CommandAttr<RecyclerViewImpl_removeAllItems>();
		}
		
		let wrapper:RecyclerViewImpl_removeAllItems = new RecyclerViewImpl_removeAllItems();
		wrapper.sectionId = sectionId;
		this.removeAllItems_.setSetter(true);
		this.removeAllItems_.setValue(wrapper);	
		this.orderSet++;
		this.removeAllItems_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public updateSectionItem(sectionId : string,
itemConfigId : string,
itemId : string,
item : any) : T {
		this.resetIfRequired();
		if (this.updateSectionItem_ == null || this.updateSectionItem_ == undefined) {
			this.updateSectionItem_ = new CommandAttr<RecyclerViewImpl_updateSectionItem>();
		}
		
		let wrapper:RecyclerViewImpl_updateSectionItem = new RecyclerViewImpl_updateSectionItem();
		wrapper.sectionId = sectionId;
		wrapper.itemConfigId = itemConfigId;
		wrapper.itemId = itemId;
		wrapper.item = item;
		this.updateSectionItem_.setSetter(true);
		this.updateSectionItem_.setValue(wrapper);	
		this.orderSet++;
		this.updateSectionItem_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setStackFromEnd(value : boolean) : T {
		this.resetIfRequired();
		if (this.stackFromEnd == null || this.stackFromEnd == undefined) {
			this.stackFromEnd = new CommandAttr<boolean>();
		}
		
		this.stackFromEnd.setSetter(true);
		this.stackFromEnd.setValue(value);
		this.orderSet++;
		this.stackFromEnd.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public tryGetReverseLayout() : T {
		this.resetIfRequired();
		if (this.reverseLayout == null || this.reverseLayout == undefined) {
			this.reverseLayout = new CommandAttr<boolean>()
		}
		
		this.reverseLayout.setGetter(true);
		this.orderGet++;
		this.reverseLayout.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public isReverseLayout() : boolean {
		if (this.reverseLayout == null || this.reverseLayout == undefined) {
			this.reverseLayout = new CommandAttr<boolean>();
		}
		return this.reverseLayout.getCommandReturnValue();
	}
	public setReverseLayout(value : boolean) : T {
		this.resetIfRequired();
		if (this.reverseLayout == null || this.reverseLayout == undefined) {
			this.reverseLayout = new CommandAttr<boolean>();
		}
		
		this.reverseLayout.setSetter(true);
		this.reverseLayout.setValue(value);
		this.orderSet++;
		this.reverseLayout.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public scrollToEnd(value : boolean) : T {
		this.resetIfRequired();
		if (this.scrollToEnd_ == null || this.scrollToEnd_ == undefined) {
			this.scrollToEnd_ = new CommandAttr<boolean>();
		}
		
		this.scrollToEnd_.setSetter(true);
		this.scrollToEnd_.setValue(value);
		this.orderSet++;
		this.scrollToEnd_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public scrollToTop(value : boolean) : T {
		this.resetIfRequired();
		if (this.scrollToTop_ == null || this.scrollToTop_ == undefined) {
			this.scrollToTop_ = new CommandAttr<boolean>();
		}
		
		this.scrollToTop_.setSetter(true);
		this.scrollToTop_.setValue(value);
		this.orderSet++;
		this.scrollToTop_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public scrollToPosition(value : number) : T {
		this.resetIfRequired();
		if (this.scrollToPosition_ == null || this.scrollToPosition_ == undefined) {
			this.scrollToPosition_ = new CommandAttr<number>();
		}
		
		this.scrollToPosition_.setSetter(true);
		this.scrollToPosition_.setValue(value);
		this.orderSet++;
		this.scrollToPosition_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSwtIncrement(value : number) : T {
		this.resetIfRequired();
		if (this.swtIncrement == null || this.swtIncrement == undefined) {
			this.swtIncrement = new CommandAttr<number>();
		}
		
		this.swtIncrement.setSetter(true);
		this.swtIncrement.setValue(value);
		this.orderSet++;
		this.swtIncrement.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setNestedScrollStopDelay(value : number) : T {
		this.resetIfRequired();
		if (this.nestedScrollStopDelay == null || this.nestedScrollStopDelay == undefined) {
			this.nestedScrollStopDelay = new CommandAttr<number>();
		}
		
		this.nestedScrollStopDelay.setSetter(true);
		this.nestedScrollStopDelay.setValue(value);
		this.orderSet++;
		this.nestedScrollStopDelay.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnScrollStateChange(value : string) : T {
		this.resetIfRequired();
		if (this.onScrollStateChange == null || this.onScrollStateChange == undefined) {
			this.onScrollStateChange = new CommandAttr<string>();
		}
		
		this.onScrollStateChange.setSetter(true);
		this.onScrollStateChange.setValue(value);
		this.orderSet++;
		this.onScrollStateChange.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnScrolled(value : string) : T {
		this.resetIfRequired();
		if (this.onScrolled == null || this.onScrolled == undefined) {
			this.onScrolled = new CommandAttr<string>();
		}
		
		this.onScrolled.setSetter(true);
		this.onScrolled.setValue(value);
		this.orderSet++;
		this.onScrolled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setHeaderDisabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.headerDisabled == null || this.headerDisabled == undefined) {
			this.headerDisabled = new CommandAttr<boolean>();
		}
		
		this.headerDisabled.setSetter(true);
		this.headerDisabled.setValue(value);
		this.orderSet++;
		this.headerDisabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFooterDisabled(value : boolean) : T {
		this.resetIfRequired();
		if (this.footerDisabled == null || this.footerDisabled == undefined) {
			this.footerDisabled = new CommandAttr<boolean>();
		}
		
		this.footerDisabled.setSetter(true);
		this.footerDisabled.setValue(value);
		this.orderSet++;
		this.footerDisabled.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		
	//end - body

}
	
//start - staticinit

export class RecyclerView extends RecyclerViewImpl<RecyclerView> implements IWidget{
    getThisPointer(): RecyclerView {
        return this;
    }
    
   	public getClass() {
		return RecyclerView;
	}
	
   	constructor(id: string, path: string[], event: string) {
		super(id, path, event);	
	}
}

RecyclerViewImpl.initialize();

//end - staticinit
