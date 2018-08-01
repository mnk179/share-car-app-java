//@flow

export interface UserService {
    getSingle(userId: UserId): Promise<User>;
}