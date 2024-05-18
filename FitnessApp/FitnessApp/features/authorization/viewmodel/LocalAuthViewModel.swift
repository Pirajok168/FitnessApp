import Foundation
import fitness

class LocalAuthorizationViewModel: ObservableObject {
    private(set) var viewModel: AuthorizationEnterPhoneViewModel = AuthorizationEnterPhoneViewModel()
    
    @Published var numberPhone: String = ""
    

    
    init(){
        viewModel.viewStates().watch { [weak self] viewState in
            guard let self = self else { return }
            self.numberPhone = viewState.numberPhone
        }
    }
    
    func obtainEvent(viewEvent: AuthorizationEnterPhoneEvents){
        viewModel.obtainEvent(viewEvent: viewEvent)
    }
}
