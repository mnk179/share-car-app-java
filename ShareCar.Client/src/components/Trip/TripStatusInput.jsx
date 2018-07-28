// @flow
import * as React from "react";
import * as ShareCarAppItem from "../../data/ShareCarAppItem.js";

type TripStatusInputProps = {
    status: ShareCarAppItem.Status
}

export class TripStatusInput extends React.Component<TripStatusInputProps> {
    render(){
        return (
            <select name="trip status" defaultValue={this.props.status}>
                {ShareCarAppItem.Status.map((x,i) =>
                    <option key={i} value={x}>{x}</option>)
                }
            </select>
        );
    }
}