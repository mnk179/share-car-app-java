// @flow

export interface TripService {
    getAll(): Promise<Trip[]>;
    getListByDate(date: DateTime): Promise<Trip[]>;
    // getSingle(trip: Trip): Promise<Trip>;
    add(item: AddTripRequest): Promise<AddTripResponse>;

    // update(id: TodoItemId, payload: UpdateTodoItemRequest): Promise<void>;
    // remove(id: TodoItemId): Promise<void>;
    // updateStatus(id: TodoItemId, status: TodoItemStatus): Promise<void>;
}