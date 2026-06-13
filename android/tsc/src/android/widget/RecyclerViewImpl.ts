// start - imports

export const enum Orientation {
horizontal = "horizontal",
vertical = "vertical",
}
export const enum DragDirs {
none = "none",
up = "up",
down = "down",
left = "left",
right = "right",
}
export const enum SwipeDirs {
none = "none",
up = "up",
down = "down",
left = "left",
right = "right",
}
export const enum DragDropMode {
none = "none",
swaponhighlight = "swaponhighlight",
swapwhendropped = "swapwhendropped",
}
export const enum DragStartMode {
none = "none",
longpress = "longpress",
onclick = "onclick",
}
export const enum DragSwapMode {
none = "none",
notifyDataSetChanged = "notifyDataSetChanged",
notifyItemMoved = "notifyItemMoved",
}
export const enum SwipeSwapMode {
none = "none",
notifyDataSetChanged = "notifyDataSetChanged",
notifyItemRemoved = "notifyItemRemoved",
}	
import CommandAttr from '../../widget/CommandAttr';
import IWidget from '../../widget/IWidget';
import ILayoutParam from '../../widget/ILayoutParam';
import {plainToClass, Type, Exclude, Expose, Transform} from "class-transformer";
import {Gravity} from '../../widget/TypeConstants';
import {ITranform, TransformerFactory} from '../../widget/TransformerFactory';
import {Event} from '../../app/Event';
import {MotionEvent} from '../../app/MotionEvent';
import {DragEvent} from '../../app/DragEvent';
import {KeyEvent} from '../../app/KeyEvent';
import { ScopedObject } from '../../app/ScopedObject';
import { Mixin, decorate } from 'ts-mixer';










export class RecyclerViewImpl_addSectionItem {
@decorate(Expose({ name: "sectionId" }))
sectionId!:string;
@decorate(Expose({ name: "itemConfigId" }))
itemConfigId!:string;
@decorate(Expose({ name: "item" }))
item!:any;
}
export class RecyclerViewImpl_removeSectionItem {
@decorate(Expose({ name: "sectionId" }))
sectionId!:string;
@decorate(Expose({ name: "itemConfigId" }))
itemConfigId!:string;
@decorate(Expose({ name: "itemId" }))
itemId!:string;
}
export class RecyclerViewImpl_removeAllItems {
@decorate(Expose({ name: "sectionId" }))
sectionId!:string;
@decorate(Expose({ name: "itemConfigId" }))
itemConfigId!:string;
}
export class RecyclerViewImpl_updateSectionItem {
@decorate(Expose({ name: "sectionId" }))
sectionId!:string;
@decorate(Expose({ name: "itemConfigId" }))
itemConfigId!:string;
@decorate(Expose({ name: "itemId" }))
itemId!:string;
@decorate(Expose({ name: "item" }))
item!:any;
}





















export class DragDirsTransformer implements ITranform {
    transform(value: any, obj: any, type: number) : any{
        if (type == 1) {
            return value.toString().replace(",", "|");
        } else {
            let strArray:Array<string> = value.toString().split("|");
            
            let valueArr:Array<DragDirs> = new Array<DragDirs>();
            for (let i =0; i < strArray.length; i++) {
                switch(strArray[i]) {
					case "none":
						valueArr.push(DragDirs.none);
                       	break;	
					case "up":
						valueArr.push(DragDirs.up);
                       	break;	
					case "down":
						valueArr.push(DragDirs.down);
                       	break;	
					case "left":
						valueArr.push(DragDirs.left);
                       	break;	
					case "right":
						valueArr.push(DragDirs.right);
                       	break;	
                }
                
            }
            return valueArr;
        }
    }
}

export class SwipeDirsTransformer implements ITranform {
    transform(value: any, obj: any, type: number) : any{
        if (type == 1) {
            return value.toString().replace(",", "|");
        } else {
            let strArray:Array<string> = value.toString().split("|");
            
            let valueArr:Array<SwipeDirs> = new Array<SwipeDirs>();
            for (let i =0; i < strArray.length; i++) {
                switch(strArray[i]) {
					case "none":
						valueArr.push(SwipeDirs.none);
                       	break;	
					case "up":
						valueArr.push(SwipeDirs.up);
                       	break;	
					case "down":
						valueArr.push(SwipeDirs.down);
                       	break;	
					case "left":
						valueArr.push(SwipeDirs.left);
                       	break;	
					case "right":
						valueArr.push(SwipeDirs.right);
                       	break;	
                }
                
            }
            return valueArr;
        }
    }
}











import {ViewGroupImpl_LayoutParams} from './ViewGroupImpl';

// end - imports
import {ViewGroupImpl} from './ViewGroupImpl';
export abstract class RecyclerViewImpl<T> extends ViewGroupImpl<T>{
	//start - body
	static initialize() {
		TransformerFactory.getInstance().register("dragDirs", new DragDirsTransformer());
		TransformerFactory.getInstance().register("swipeDirs", new SwipeDirsTransformer());
    }	
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onFling" }))
	onFling!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onScrollStateChange" }))
	onScrollStateChange!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onScrolled" }))
	onScrolled!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "layoutManager" }))
	layoutManager!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "viewHolderIds" }))
	viewHolderIds!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "spanCount" }))
	spanCount!:CommandAttr<number>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "layout" }))
	layout!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "orientation" }))
	orientation!:CommandAttr<Orientation>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "nestedScrollingEnabled" }))
	nestedScrollingEnabled!:CommandAttr<boolean>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "addSectionItem" }))
	addSectionItem_!:CommandAttr<RecyclerViewImpl_addSectionItem>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "removeSectionItem" }))
	removeSectionItem_!:CommandAttr<RecyclerViewImpl_removeSectionItem>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "removeAllItems" }))
	removeAllItems_!:CommandAttr<RecyclerViewImpl_removeAllItems>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "updateSectionItem" }))
	updateSectionItem_!:CommandAttr<RecyclerViewImpl_updateSectionItem>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "stackFromEnd" }))
	stackFromEnd!:CommandAttr<boolean>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "reverseLayout" }))
	reverseLayout!:CommandAttr<boolean>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "scrollToEnd" }))
	scrollToEnd_!:CommandAttr<boolean>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "scrollToTop" }))
	scrollToTop_!:CommandAttr<boolean>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "scrollToPosition" }))
	scrollToPosition_!:CommandAttr<number>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "headerDisabled" }))
	headerDisabled!:CommandAttr<boolean>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "footerDisabled" }))
	footerDisabled!:CommandAttr<boolean>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "filter" }))
	filter_!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "filterDelay" }))
	filterDelay!:CommandAttr<number>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "filterId" }))
	filterId!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "filterItemPath" }))
	filterItemPath!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "filterSectionPath" }))
	filterSectionPath!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "filterQueryStorePath" }))
	filterQueryStorePath!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "filterQueryGetPath" }))
	filterQueryGetPath!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "fixedgrid_rowCount" }))
	fixedgrid_rowCount!:CommandAttr<number>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "fixedgrid_columnCount" }))
	fixedgrid_columnCount!:CommandAttr<number>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "fixedgrid_tileWidth" }))
	fixedgrid_tileWidth!:CommandAttr<number>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "fixedgrid_tileHeight" }))
	fixedgrid_tileHeight!:CommandAttr<number>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "disableItemAnimator" }))
	disableItemAnimator_!:CommandAttr<void>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "hasFixedSize" }))
	hasFixedSize!:CommandAttr<boolean>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "dragDirs" }))
	dragDirs!:CommandAttr<DragDirs[]>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "swipeDirs" }))
	swipeDirs!:CommandAttr<SwipeDirs[]>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "dragDropMode" }))
	dragDropMode!:CommandAttr<DragDropMode>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "dragStartMode" }))
	dragStartMode!:CommandAttr<DragStartMode>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "dragSwapMode" }))
	dragSwapMode!:CommandAttr<DragSwapMode>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "dragSelectHighlightAttributes" }))
	dragSelectHighlightAttributes!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "dragResetHighlightAttributes" }))
	dragResetHighlightAttributes!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "swipeSwapMode" }))
	swipeSwapMode!:CommandAttr<SwipeSwapMode>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "deleteOnSwipe" }))
	deleteOnSwipe!:CommandAttr<boolean>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onSwiped" }))
	onSwiped!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onMove" }))
	onMove!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onMoved" }))
	onMoved!:CommandAttr<string>| undefined;
	@decorate(Type(() => CommandAttr))
	@decorate(Expose({ name: "onSelectedChanged" }))
	onSelectedChanged!:CommandAttr<string>| undefined;

	@decorate(Exclude())
	protected thisPointer: T;	
	protected abstract getThisPointer(): T;
	reset() : T {	
		super.reset();
		this.onFling = undefined;
		this.onScrollStateChange = undefined;
		this.onScrolled = undefined;
		this.layoutManager = undefined;
		this.viewHolderIds = undefined;
		this.spanCount = undefined;
		this.layout = undefined;
		this.orientation = undefined;
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
		this.headerDisabled = undefined;
		this.footerDisabled = undefined;
		this.filter_ = undefined;
		this.filterDelay = undefined;
		this.filterId = undefined;
		this.filterItemPath = undefined;
		this.filterSectionPath = undefined;
		this.filterQueryStorePath = undefined;
		this.filterQueryGetPath = undefined;
		this.fixedgrid_rowCount = undefined;
		this.fixedgrid_columnCount = undefined;
		this.fixedgrid_tileWidth = undefined;
		this.fixedgrid_tileHeight = undefined;
		this.disableItemAnimator_ = undefined;
		this.hasFixedSize = undefined;
		this.dragDirs = undefined;
		this.swipeDirs = undefined;
		this.dragDropMode = undefined;
		this.dragStartMode = undefined;
		this.dragSwapMode = undefined;
		this.dragSelectHighlightAttributes = undefined;
		this.dragResetHighlightAttributes = undefined;
		this.swipeSwapMode = undefined;
		this.deleteOnSwipe = undefined;
		this.onSwiped = undefined;
		this.onMove = undefined;
		this.onMoved = undefined;
		this.onSelectedChanged = undefined;
		return this.thisPointer;
	}
	constructor(id: string, path: string[], event:  string) {
		super(id, path, event);
		this.thisPointer = this.getThisPointer();
	}
	

	public setOnFling(value : string) : T {
		this.resetIfRequired();
		if (this.onFling == null || this.onFling == undefined) {
			this.onFling = new CommandAttr<string>();
		}
		
		this.onFling.setSetter(true);
		this.onFling.setValue(value);
		this.orderSet++;
		this.onFling.setOrderSet(this.orderSet);
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
		

	public tryGetOrientation() : T {
		this.resetIfRequired();
		if (this.orientation == null || this.orientation == undefined) {
			this.orientation = new CommandAttr<Orientation>()
		}
		
		this.orientation.setGetter(true);
		this.orderGet++;
		this.orientation.setOrderGet(this.orderGet);
		return this.thisPointer;
	}
	
	public getOrientation() : Orientation {
		if (this.orientation == null || this.orientation == undefined) {
			this.orientation = new CommandAttr<Orientation>();
		}
		return this.orientation.getCommandReturnValue();
	}
	public setOrientation(value : Orientation) : T {
		this.resetIfRequired();
		if (this.orientation == null || this.orientation == undefined) {
			this.orientation = new CommandAttr<Orientation>();
		}
		
		this.orientation.setSetter(true);
		this.orientation.setValue(value);
		this.orderSet++;
		this.orientation.setOrderSet(this.orderSet);
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
		

	public removeAllItems(sectionId : string,
itemConfigId : string) : T {
		this.resetIfRequired();
		if (this.removeAllItems_ == null || this.removeAllItems_ == undefined) {
			this.removeAllItems_ = new CommandAttr<RecyclerViewImpl_removeAllItems>();
		}
		
		let wrapper:RecyclerViewImpl_removeAllItems = new RecyclerViewImpl_removeAllItems();
		wrapper.sectionId = sectionId;
		wrapper.itemConfigId = itemConfigId;
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
		

	public filter(value : string) : T {
		this.resetIfRequired();
		if (this.filter_ == null || this.filter_ == undefined) {
			this.filter_ = new CommandAttr<string>();
		}
		
		this.filter_.setSetter(true);
		this.filter_.setValue(value);
		this.orderSet++;
		this.filter_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFilterDelay(value : number) : T {
		this.resetIfRequired();
		if (this.filterDelay == null || this.filterDelay == undefined) {
			this.filterDelay = new CommandAttr<number>();
		}
		
		this.filterDelay.setSetter(true);
		this.filterDelay.setValue(value);
		this.orderSet++;
		this.filterDelay.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFilterId(value : string) : T {
		this.resetIfRequired();
		if (this.filterId == null || this.filterId == undefined) {
			this.filterId = new CommandAttr<string>();
		}
		
		this.filterId.setSetter(true);
		this.filterId.setValue(value);
		this.orderSet++;
		this.filterId.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFilterItemPath(value : string) : T {
		this.resetIfRequired();
		if (this.filterItemPath == null || this.filterItemPath == undefined) {
			this.filterItemPath = new CommandAttr<string>();
		}
		
		this.filterItemPath.setSetter(true);
		this.filterItemPath.setValue(value);
		this.orderSet++;
		this.filterItemPath.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFilterSectionPath(value : string) : T {
		this.resetIfRequired();
		if (this.filterSectionPath == null || this.filterSectionPath == undefined) {
			this.filterSectionPath = new CommandAttr<string>();
		}
		
		this.filterSectionPath.setSetter(true);
		this.filterSectionPath.setValue(value);
		this.orderSet++;
		this.filterSectionPath.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFilterQueryStorePath(value : string) : T {
		this.resetIfRequired();
		if (this.filterQueryStorePath == null || this.filterQueryStorePath == undefined) {
			this.filterQueryStorePath = new CommandAttr<string>();
		}
		
		this.filterQueryStorePath.setSetter(true);
		this.filterQueryStorePath.setValue(value);
		this.orderSet++;
		this.filterQueryStorePath.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFilterQueryGetPath(value : string) : T {
		this.resetIfRequired();
		if (this.filterQueryGetPath == null || this.filterQueryGetPath == undefined) {
			this.filterQueryGetPath = new CommandAttr<string>();
		}
		
		this.filterQueryGetPath.setSetter(true);
		this.filterQueryGetPath.setValue(value);
		this.orderSet++;
		this.filterQueryGetPath.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFixedgrid_rowCount(value : number) : T {
		this.resetIfRequired();
		if (this.fixedgrid_rowCount == null || this.fixedgrid_rowCount == undefined) {
			this.fixedgrid_rowCount = new CommandAttr<number>();
		}
		
		this.fixedgrid_rowCount.setSetter(true);
		this.fixedgrid_rowCount.setValue(value);
		this.orderSet++;
		this.fixedgrid_rowCount.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFixedgrid_columnCount(value : number) : T {
		this.resetIfRequired();
		if (this.fixedgrid_columnCount == null || this.fixedgrid_columnCount == undefined) {
			this.fixedgrid_columnCount = new CommandAttr<number>();
		}
		
		this.fixedgrid_columnCount.setSetter(true);
		this.fixedgrid_columnCount.setValue(value);
		this.orderSet++;
		this.fixedgrid_columnCount.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFixedgrid_tileWidth(value : number) : T {
		this.resetIfRequired();
		if (this.fixedgrid_tileWidth == null || this.fixedgrid_tileWidth == undefined) {
			this.fixedgrid_tileWidth = new CommandAttr<number>();
		}
		
		this.fixedgrid_tileWidth.setSetter(true);
		this.fixedgrid_tileWidth.setValue(value);
		this.orderSet++;
		this.fixedgrid_tileWidth.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setFixedgrid_tileHeight(value : number) : T {
		this.resetIfRequired();
		if (this.fixedgrid_tileHeight == null || this.fixedgrid_tileHeight == undefined) {
			this.fixedgrid_tileHeight = new CommandAttr<number>();
		}
		
		this.fixedgrid_tileHeight.setSetter(true);
		this.fixedgrid_tileHeight.setValue(value);
		this.orderSet++;
		this.fixedgrid_tileHeight.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public disableItemAnimator() : T {
		this.resetIfRequired();
		if (this.disableItemAnimator_ == null || this.disableItemAnimator_ == undefined) {
			this.disableItemAnimator_ = new CommandAttr<void>();
		}
		
		this.disableItemAnimator_.setSetter(true);
		
		this.orderSet++;
		this.disableItemAnimator_.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setHasFixedSize(value : boolean) : T {
		this.resetIfRequired();
		if (this.hasFixedSize == null || this.hasFixedSize == undefined) {
			this.hasFixedSize = new CommandAttr<boolean>();
		}
		
		this.hasFixedSize.setSetter(true);
		this.hasFixedSize.setValue(value);
		this.orderSet++;
		this.hasFixedSize.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDragDirs(...value : DragDirs[]) : T {
		this.resetIfRequired();
		if (this.dragDirs == null || this.dragDirs == undefined) {
			this.dragDirs = new CommandAttr<DragDirs[]>();
		}
		
		this.dragDirs.setSetter(true);
		this.dragDirs.setValue(value);
		this.orderSet++;
		this.dragDirs.setOrderSet(this.orderSet);
this.dragDirs.setTransformer('dragDirs');		return this.thisPointer;
	}
		

	public setSwipeDirs(...value : SwipeDirs[]) : T {
		this.resetIfRequired();
		if (this.swipeDirs == null || this.swipeDirs == undefined) {
			this.swipeDirs = new CommandAttr<SwipeDirs[]>();
		}
		
		this.swipeDirs.setSetter(true);
		this.swipeDirs.setValue(value);
		this.orderSet++;
		this.swipeDirs.setOrderSet(this.orderSet);
this.swipeDirs.setTransformer('swipeDirs');		return this.thisPointer;
	}
		

	public setDragDropMode(value : DragDropMode) : T {
		this.resetIfRequired();
		if (this.dragDropMode == null || this.dragDropMode == undefined) {
			this.dragDropMode = new CommandAttr<DragDropMode>();
		}
		
		this.dragDropMode.setSetter(true);
		this.dragDropMode.setValue(value);
		this.orderSet++;
		this.dragDropMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDragStartMode(value : DragStartMode) : T {
		this.resetIfRequired();
		if (this.dragStartMode == null || this.dragStartMode == undefined) {
			this.dragStartMode = new CommandAttr<DragStartMode>();
		}
		
		this.dragStartMode.setSetter(true);
		this.dragStartMode.setValue(value);
		this.orderSet++;
		this.dragStartMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDragSwapMode(value : DragSwapMode) : T {
		this.resetIfRequired();
		if (this.dragSwapMode == null || this.dragSwapMode == undefined) {
			this.dragSwapMode = new CommandAttr<DragSwapMode>();
		}
		
		this.dragSwapMode.setSetter(true);
		this.dragSwapMode.setValue(value);
		this.orderSet++;
		this.dragSwapMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDragSelectHighlightAttributes(value : string) : T {
		this.resetIfRequired();
		if (this.dragSelectHighlightAttributes == null || this.dragSelectHighlightAttributes == undefined) {
			this.dragSelectHighlightAttributes = new CommandAttr<string>();
		}
		
		this.dragSelectHighlightAttributes.setSetter(true);
		this.dragSelectHighlightAttributes.setValue(value);
		this.orderSet++;
		this.dragSelectHighlightAttributes.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDragResetHighlightAttributes(value : string) : T {
		this.resetIfRequired();
		if (this.dragResetHighlightAttributes == null || this.dragResetHighlightAttributes == undefined) {
			this.dragResetHighlightAttributes = new CommandAttr<string>();
		}
		
		this.dragResetHighlightAttributes.setSetter(true);
		this.dragResetHighlightAttributes.setValue(value);
		this.orderSet++;
		this.dragResetHighlightAttributes.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setSwipeSwapMode(value : SwipeSwapMode) : T {
		this.resetIfRequired();
		if (this.swipeSwapMode == null || this.swipeSwapMode == undefined) {
			this.swipeSwapMode = new CommandAttr<SwipeSwapMode>();
		}
		
		this.swipeSwapMode.setSetter(true);
		this.swipeSwapMode.setValue(value);
		this.orderSet++;
		this.swipeSwapMode.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setDeleteOnSwipe(value : boolean) : T {
		this.resetIfRequired();
		if (this.deleteOnSwipe == null || this.deleteOnSwipe == undefined) {
			this.deleteOnSwipe = new CommandAttr<boolean>();
		}
		
		this.deleteOnSwipe.setSetter(true);
		this.deleteOnSwipe.setValue(value);
		this.orderSet++;
		this.deleteOnSwipe.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnSwiped(value : string) : T {
		this.resetIfRequired();
		if (this.onSwiped == null || this.onSwiped == undefined) {
			this.onSwiped = new CommandAttr<string>();
		}
		
		this.onSwiped.setSetter(true);
		this.onSwiped.setValue(value);
		this.orderSet++;
		this.onSwiped.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnMove(value : string) : T {
		this.resetIfRequired();
		if (this.onMove == null || this.onMove == undefined) {
			this.onMove = new CommandAttr<string>();
		}
		
		this.onMove.setSetter(true);
		this.onMove.setValue(value);
		this.orderSet++;
		this.onMove.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnMoved(value : string) : T {
		this.resetIfRequired();
		if (this.onMoved == null || this.onMoved == undefined) {
			this.onMoved = new CommandAttr<string>();
		}
		
		this.onMoved.setSetter(true);
		this.onMoved.setValue(value);
		this.orderSet++;
		this.onMoved.setOrderSet(this.orderSet);
		return this.thisPointer;
	}
		

	public setOnSelectedChanged(value : string) : T {
		this.resetIfRequired();
		if (this.onSelectedChanged == null || this.onSelectedChanged == undefined) {
			this.onSelectedChanged = new CommandAttr<string>();
		}
		
		this.onSelectedChanged.setSetter(true);
		this.onSelectedChanged.setValue(value);
		this.orderSet++;
		this.onSelectedChanged.setOrderSet(this.orderSet);
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
export interface OnFlingEvent extends Event{
	        velocityX:number;
	        velocityY:number;

}
export interface OnScrollStateChangeEvent extends Event{
        //recyclerView:RecyclerView;

	        newState:number;

}
export interface OnScrolledEvent extends Event{
        //recyclerView:RecyclerView;

	        dx:number;
	        dy:number;

}
export interface OnSwipedEvent extends Event{
        //viewHolder:ViewHolder;

	        direction:number;

}
export interface OnMoveEvent extends Event{
        //recyclerView:RecyclerView;

        //viewHolder:ViewHolder;

        //target:ViewHolder;


}
export interface OnMovedEvent extends Event{
        //recyclerView:RecyclerView;

        //viewHolder:ViewHolder;

	        fromPos:number;
        //target:ViewHolder;

	        toPos:number;
	        x:number;
	        y:number;

}
export interface OnSelectedChangedEvent extends Event{
        //viewHolder:ViewHolder;

	        actionState:number;

}
export interface OnSwipedEvent extends Event{
        //viewHolder:ViewHolder;

	        direction:number;

}
export interface OnMoveEvent extends Event{
        //recyclerView:RecyclerView;

        //viewHolder:ViewHolder;

        //target:ViewHolder;


}
export interface OnMovedEvent extends Event{
        //recyclerView:RecyclerView;

        //viewHolder:ViewHolder;

	        fromPos:number;
        //target:ViewHolder;

	        toPos:number;
	        x:number;
	        y:number;

}
export interface OnSelectedChangedEvent extends Event{
        //viewHolder:ViewHolder;

	        actionState:number;

}
export interface OnSwipedEvent extends Event{
        //viewHolder:ViewHolder;

	        direction:number;

}
export interface OnMoveEvent extends Event{
        //recyclerView:RecyclerView;

        //viewHolder:ViewHolder;

        //target:ViewHolder;


}
export interface OnMovedEvent extends Event{
        //recyclerView:RecyclerView;

        //viewHolder:ViewHolder;

	        fromPos:number;
        //target:ViewHolder;

	        toPos:number;
	        x:number;
	        y:number;

}
export interface OnSelectedChangedEvent extends Event{
        //viewHolder:ViewHolder;

	        actionState:number;

}
export interface OnSwipedEvent extends Event{
        //viewHolder:ViewHolder;

	        direction:number;

}
export interface OnMoveEvent extends Event{
        //recyclerView:RecyclerView;

        //viewHolder:ViewHolder;

        //target:ViewHolder;


}
export interface OnMovedEvent extends Event{
        //recyclerView:RecyclerView;

        //viewHolder:ViewHolder;

	        fromPos:number;
        //target:ViewHolder;

	        toPos:number;
	        x:number;
	        y:number;

}
export interface OnSelectedChangedEvent extends Event{
        //viewHolder:ViewHolder;

	        actionState:number;

}

//end - staticinit
