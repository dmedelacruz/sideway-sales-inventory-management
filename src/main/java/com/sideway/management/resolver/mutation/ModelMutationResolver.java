package com.sideway.management.resolver.mutation;

import com.sideway.management.exception.validation.DuplicateCodeException;
import com.sideway.management.model.Model;
import com.sideway.management.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelMutationResolver {

    private final ModelRepository modelRepository;

    public Model newModel(String code, String name) {
        try {
            Model model = new Model();
            model.setCode(code);
            model.setName(name);

            final val modelEntity = modelRepository.save(model);
            return modelEntity;
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new DuplicateCodeException("Model code already exists");
            //TODO also handle duplicate Model name
        }
    }

}
