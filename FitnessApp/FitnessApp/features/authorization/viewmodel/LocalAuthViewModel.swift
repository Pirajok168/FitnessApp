import Foundation
import fitness

class LocalAuthorizationViewModel: ObservableObject {
    private(set) var viewModel: AuthorizationViewModel = AuthorizationViewModel()
    
    @Published var login: String = ""
    
    @Published var password: String = ""
    
    init(){
        viewModel.viewStates().watch { [weak self] viewState in
            guard let self = self else { return }
            self.login = viewState.login
            self.password = viewState.password
        }
    }
    
    func obtainEvent(viewEvent: AuthorizationEvents){
        viewModel.obtainEvent(viewEvent: viewEvent)
    }
}
