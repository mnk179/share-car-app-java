// @flow
import * as React from "react";

type NewTripFormProps = {
    onUpdate: (item: Trip) => mixed,
    trip?: Trip,
    onFullDataRequest?: () => Promise<Trip>;
};

type NewTripFormState = {
    isLoading: boolean,
    trip?: Trip
}

export class NewTripForm extends React.Component<NewTripFormProps, NewTripFormState>{
    state = {
        isLoading: true
    }
    async componentDidMount() {
        if (this.props.onFullDataRequest !== undefined) {
            const data = await this.props.onFullDataRequest();
            await new Promise(resolve => setTimeout(resolve, 1000)); //sleep 1000ms
            this.setState({isLoading: false, trip: data});
        } else {
            this.setState({...this.state, isLoading: false});
        }
    }
    handleSubmit(e: any) {
        e.preventDefault();
        const newData = {
            id: this.props.trip !== undefined ? this.props.trip.id : 0, // TODO: fix this
            route: e.target.route.value,
            dateTime: e.target.dateTime.value,
            driverId: e.target.driverId.value
        };

        this.props.onUpdate(newData);
    }
    render(){
        if (this.state.isLoading) {
            return "Loading";
        }
        const item: Trip = {...this.state.trip};
        return(
            <form onSubmit={this.handleSubmit.bind(this)}>
                Route: <input type="text" name="route" defaultValue={item.route}/>
                <br/>
                DateTime: <input type="text" name="dateTime" defaultValue={item.dateTime}/>
                <br/>
                DriverId: <input type="text" name="driverId" defaultValue={item.driverId}/>
                </select>
                <br/>
                <button>Save</button>
            </form>
        );
    }
}