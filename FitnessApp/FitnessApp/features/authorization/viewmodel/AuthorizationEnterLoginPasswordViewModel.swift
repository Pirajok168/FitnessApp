//
//  AuthorizationEnterLoginPasswordViewModel.swift
//  FitnessApp
//
//  Created by Данила Еремин on 18.05.2024.
//

import Foundation
import fitness


class LocalAuthorizationEnterLoginPasswordViewModel: ObservableObject {
    private(set) var viewModel: AuthorizationEnterLoginPasswordViewModel = AuthorizationEnterLoginPasswordViewModel()
    
    @Published var login: String = ""
    @Published var password: String = ""
    
    @Published var showPassword: Bool = false
    

    
    init(){
        viewModel.viewStates().watch { [weak self] viewState in
            guard let self = self else { return }
            self.login = viewState.login
            self.password = viewState.password
        }
    }
    
    func onShowPassword(){
        showPassword.toggle()
    }
    
    func obtainEvent(viewEvent: AuthorizationEnterLoginPasswordEvents){
        viewModel.obtainEvent(viewEvent: viewEvent)
    }
}
