//@flow
import * as React from "react";
import {TripStatusInput} from "./TripStatusInput";

type ShareCarAppItemContainerProps = {

}

export class ShareCarAppItemContainer extends React.Component<ShareCarAppItemContainerProps>{
    render(){
        return (
            <div className="ShareCarApp-item-container">
                <TripStatusInput status={this.props.Status}/>
                   {// <PriorityBadge priority={this.props.todoItem.priority}/>
                   // <TodoItemTitle title={this.props.todoItem.title}/>
                    
                    //<EditTodoItem onEdit={() => this.setState({isOpen: !this.state.isOpen})}/>
                    //<RemoveTodoItem onRemove={()=> console.log("Deleting task with id: ", this.props.todoItem.id)}/>
                    }</div>
        );
    }
}